package com.app.services;

import com.app.dto.ProductsDTO;
import com.app.dto.ProductsRespDTO;

public interface ProductService {

	ProductsRespDTO saveProduct(ProductsDTO product);

}
