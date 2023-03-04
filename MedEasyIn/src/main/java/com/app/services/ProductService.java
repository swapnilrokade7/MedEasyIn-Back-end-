package com.app.services;

import java.util.List;

import com.app.dto.ProductsDTO;
import com.app.dto.ProductsRespDTO;
import com.app.entities.Categories;
import com.app.entities.Products;
import com.app.entities.projections.ProductsProjection;

public interface ProductService {

	ProductsRespDTO saveProduct(ProductsDTO product);

	List<ProductsProjection> getProductsByCategory(Long categoryId);

	void deleteProduct(Long productId);

	List<ProductsProjection> findAllProducts();

	void updateProduct(ProductsDTO product, Long productId);

	
	

}
