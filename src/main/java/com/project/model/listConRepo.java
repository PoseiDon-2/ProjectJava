package com.project.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class listConRepo {


	@PersistenceContext
	private EntityManager em;
	
	 @SuppressWarnings("unchecked")
	    public List<listContent> showallOrderByTargetDateTimeAsc() {
	        Query q = em.createQuery("FROM listContent lc ORDER BY lc.targetDateTime ASC");
	        return q.getResultList();
	    }
	@Transactional
	public listContent findById(Long list_id) {
		return em.find(listContent.class, list_id); 
		}
	
	@Transactional
	public listContent insertData(listContent fr) {
		em.persist(fr);
		return fr;
	}
	
	@Transactional
    public listContent update(listContent update) {
		listContent forum = em.find(listContent.class, update.getList_id());
        forum.setList_massage(update.getList_massage());
//        forum.setPost_data(update.getPost_data());
        return forum;
    }
	@Transactional
	public listContent save(listContent saveforum) {
		em.persist(saveforum); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return saveforum;
	}
	
	
	@Transactional
	public void delete(String list_id) {
		listContent fr = em.find(listContent.class, list_id); // ค ้นหาตาม id ที่ต ้องการลบ
		em.remove(fr); // เริ่มลบจริง
	}

	
}
