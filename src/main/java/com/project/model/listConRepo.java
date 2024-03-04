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

    // ดึงข้อมูลทั้งหมดจากฐานข้อมูลและเรียงลำดับตาม targetDateTime จากน้อยไปมาก ASC 
    @SuppressWarnings("unchecked")
    public List<listContent> showallOrderByTargetDateTimeAsc() {
        Query q = em.createQuery("FROM listContent lc ORDER BY lc.targetDateTime ASC");
        return q.getResultList();
    }

    // ค้นหาข้อมูลจากฐานข้อมูลด้วย ID
    @Transactional
    public listContent findById(Long list_id) {
        return em.find(listContent.class, list_id);
    }

    // เพิ่มข้อมูลลงในฐานข้อมูล
    @Transactional
    public listContent insertData(listContent fr) {
        em.persist(fr);
        return fr;
    }

//    // อัพเดทข้อมูลในฐานข้อมูล
//    @Transactional
//    public listContent update(listContent update) {
//        listContent forum = em.find(listContent.class, update.getList_id());
//        forum.setList_massage(update.getList_massage());
//        //forum.setPost_data(update.getPost_data()); // ไม่ได้ใช้งาน คอมเมนท์ไว้
//        return forum;
//    }

    // บันทึกข้อมูลในฐานข้อมูล
    @Transactional
    public listContent save(listContent saveforum) {
        em.persist(saveforum); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
        return saveforum;
    }

    // ลบข้อมูลจากฐานข้อมูลตาม ID
    @Transactional
    public void delete(String list_id) {
        listContent fr = em.find(listContent.class, list_id); // ค้นหาตาม id ที่ต้องการลบ
        em.remove(fr); // เริ่มลบจริง
    }
}
