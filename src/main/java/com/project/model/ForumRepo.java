package com.project.model;


import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ForumRepo {
	@PersistenceContext
	private EntityManager emf;
	
	
	public List<Forum> showAll() {
		Query q = emf.createQuery("from Forum");
		return q.getResultList();
	}
	
	@Transactional
	public Forum insertData(Forum fr) {
		emf.persist(fr);
		return fr;
	}
	@Transactional
	public Forum findById(Integer id) {
		return emf.find(Forum.class, id); // ค ้นหา Customer ตาม id
		}
	
	@Transactional
    public Forum update(Forum update) {
        Forum forum = emf.find(Forum.class, update.getId());
        forum.setLove(update.getLove());
//        forum.setPostDate(new Date(System.currentTimeMillis()));
        return forum;
    }
	
	public List<Forum> search(String searchTerm) {
	    String queryString = "from Forum f where f.HeadForum like :searchTerm";
	    TypedQuery<Forum> query = emf.createQuery(queryString, Forum.class);
	    query.setParameter("searchTerm", "%" + searchTerm + "%");
	    return query.getResultList();
	}

}
