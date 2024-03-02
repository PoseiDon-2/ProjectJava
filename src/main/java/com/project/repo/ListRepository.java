package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.ListItem;

public interface ListRepository extends JpaRepository<ListItem, Long> {
    // additional query methods if needed
}
