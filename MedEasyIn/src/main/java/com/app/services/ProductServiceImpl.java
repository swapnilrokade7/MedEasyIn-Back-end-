package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProductsDTO;
import com.app.dto.ProductsRespDTO;
import com.app.entities.Categories;
import com.app.entities.Products;
import com.app.entities.projections.ProductsProjection;
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
	private CartItemsService cartItemsService;

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
	
	@Override
	public List<ProductsProjection> getProductsByCategory(Long categoryId) {
		Categories category = categoryRepository.getReferenceById(categoryId);
		 List<Products> tempList=productRepository.findByCategoryId(category);
		 List<ProductsProjection> productList=new ArrayList<ProductsProjection>();
		 tempList.forEach(x->productList.add(new ProductsProjection(x.getName(), x.getPrice(), x.getDescription(), x.getStock(), x.getCategoryId().getCategoryName(), x.getImagePath(), x.getExpDate())));
		return productList;
	}

	@Override
	public void deleteProduct(Long productId) {
		Products product=productRepository.getReferenceById(productId);
		cartItemsService.deleteByProductId(product);
		
		
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<ProductsProjection> findAllProducts() {
		List<Products> tempList=productRepository.findAll();
		List<ProductsProjection> list=new ArrayList<ProductsProjection>();
		tempList.forEach(x->{
			list.add(new ProductsProjection(x.getName(), x.getPrice(), x.getDescription(), x.getStock(), x.getCategoryId().getCategoryName(), x.getImagePath(), x.getExpDate()));
		});
		return list;
	}

	@Override
	public void updateProduct(ProductsDTO product, Long productId) {
		Optional<Products> retProduct=productRepository.findById(productId);
		retProduct.get().setName(product.getName());
		retProduct.get().setDescription(product.getDescription());
		retProduct.get().setStock(product.getStock());
		retProduct.get().setPrice(product.getPrice());
//		Categories cat=categoryRepository.getReferenceById(product.getCategoryId());
//		retProduct.get().setCategoryId(cat);
		
		
		
	}



	
	
	

	

}
