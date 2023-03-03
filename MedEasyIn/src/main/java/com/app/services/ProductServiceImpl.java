package com.app.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProductsDTO;
import com.app.dto.ProductsRespDTO;
import com.app.entities.Categories;
import com.app.entities.Products;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ProductsRespDTO saveProduct(ProductsDTO product) {
		Long CatId=product.getCategoryId();
		Optional<Categories> cat1=categoryService.getCategory(CatId);
		Categories cat=categoryRepository.getReferenceById(CatId);
		
		Products newProduct=new Products(product.getName(),product.getPrice(),product.getDescription(),product.getStock(),cat);
	
		Products prod=productRepository.save(newProduct);
		return mapper.map(prod, ProductsRespDTO.class); 
	}
	

	

}
