package com.project.model;

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
	public diary findById(Integer id) {
		return em.find(diary.class, id); 
		}
	
	@Transactional
	public diary insertData(diary fr) {
		em.persist(fr);
		return fr;
	}
	
	@Transactional
    public diary update(diary update) {
		diary forum = em.find(diary.class, update.getId());
        forum.setMassage(update.getMassage());
        forum.setPost_data(update.getPost_data());
        return forum;
    }
	@Transactional
	public diary save(diary saveforum) {
		em.persist(saveforum); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return saveforum;
	}
	
	@Transactional
	public void delete(Integer id) {
		diary fr = em.find(diary.class, id); // ค ้นหาตาม id ที่ต ้องการลบ
		em.remove(fr); // เริ่มลบจริง
	}

}
