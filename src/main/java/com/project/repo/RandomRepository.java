package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.diary;

@Repository
public interface RandomRepository extends JpaRepository<diary, Integer> {

}
