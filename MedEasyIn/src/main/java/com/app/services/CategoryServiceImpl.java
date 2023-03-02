package com.app.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Categories;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Categories saveCategory(Categories Category) {
		
		return categoryRepository.save(Category);
	}
	
	@Override
	public Optional<Categories> getCategory(Long CatId) {
		
		return categoryRepository.findById(CatId);
	}
	
	
}
