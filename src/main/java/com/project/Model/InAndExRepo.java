package com.project.Model;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class InAndExRepo {
	@PersistenceContext
	private EntityManager em;
	
	public List<InAndEx> showAll() {
		Query q = em.createQuery("from InAndEx");
		return q.getResultList();
	}
	
	@Transactional
	public InAndEx insertData(InAndEx add) {
//		add.setDate(new Date(System.currentTimeMillis()));
		em.persist(add);
		return add;
	}
	
	@Transactional
	public InAndEx findById(Integer id) {
		return em.find(InAndEx.class, id); // ค ้นหา Customer ตาม id
		}
	
	@Transactional
    public InAndEx update(InAndEx update) {
		InAndEx upd = em.find(InAndEx.class, update.getId());
		upd.setIncome(update.getIncome());
		upd.setIncomedetail(update.getIncomedetail());
		upd.setExpenses(update.getExpenses());
		upd.setExpensesdetail(update.getExpensesdetail());
//        forum.setLove(update.getLove());
//        forum.setPostDate(new Date(System.currentTimeMillis()));
        return upd;
    }
	
	@Transactional
	public void delete(Integer id) {
		InAndEx de = em.find(InAndEx.class, id);
		em.remove(de);
	}
	
}

