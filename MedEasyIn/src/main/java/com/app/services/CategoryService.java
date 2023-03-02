package com.app.services;

import java.util.Optional;

import com.app.entities.Categories;

public interface CategoryService {

	Categories saveCategory(Categories Category);

	Optional<Categories> getCategory(Long CatId);

}
