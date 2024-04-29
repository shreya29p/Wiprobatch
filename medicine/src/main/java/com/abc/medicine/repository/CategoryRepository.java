package com.abc.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.medicine.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
