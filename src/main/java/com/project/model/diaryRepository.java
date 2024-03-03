package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class diaryRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<diary> showall() {
		Query q = em.createQuery("FROM diary");
		return	q.getResultList();
	}
	@Transactional
	public diary findById(Long id) {
		return em.find(diary.class, id); 
		}
	
	@Transactional
	public diary insertData(diary fr) {
		em.persist(fr);
		return fr;
	}
	
	@Transactional
    public diary update(diary update) {

		diary diary = em.find(diary.class, update.getId());
		diary.setName(update.getName());
		diary.setMassage(update.getMassage());
        return diary;

    }
	@Transactional
	public diary save(diary saveforum) {
		em.persist(saveforum); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return saveforum;
	}
	
	@Transactional
	public void delete(Long id) {
		diary fr = em.find(diary.class, id); // ค ้นหาตาม id ที่ต ้องการลบ
		em.remove(fr); // เริ่มลบจริง
	}
	
	public List<diary> searchDiary(String query) {
		String jpql = "SELECT d FROM diary d WHERE d.name LIKE :keyword OR d.massage LIKE :keyword";
	    return em.createQuery(jpql, diary.class)
	             .setParameter("keyword", "%" + query + "%")
	             .getResultList();
	}

}
