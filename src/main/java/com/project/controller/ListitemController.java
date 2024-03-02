package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.ListItem;

@RestController
@RequestMapping("/list-items")
public class ListitemController {
    @Autowired
    private ListitemController listItemRepository;

    @GetMapping
    public List<ListItem> getAllItems() {
        return listItemRepository.findAll();
    }

    @PostMapping
    public ListItem createItem(@RequestBody ListItem item) {
        return listItemRepository.save(item);
    }

    @PutMapping("/{id}")
    public ListItem updateItem(@PathVariable Long id, @RequestBody ListItem updatedItem) {
        ListItem existingItem = listItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));

        existingItem.setName(updatedItem.getName());

        return listItemRepository.save(existingItem);
    }

    // Add additional methods for delete, find by ID, etc.
}