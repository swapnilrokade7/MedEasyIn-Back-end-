package com.app.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemDTO;
import com.app.dto.CartItemRespDTO;
import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.Products;
import com.app.repository.CartItemsRepository;
import com.app.repository.CartRepository;
import com.app.repository.ProductRepository;
@Service
@Transactional
public class CartItemsServiceImple implements CartItemsService{

	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper mapper;
	
	/*Integer quantity, Double totalPrice, Carts cartId, Products productId) {
*/
	@Override
	public CartItemRespDTO addToCart(CartItemDTO cartItem) {

		Products product=productRepository.getReferenceById(cartItem.getProductId());
		Carts cart=cartRepository.getReferenceById(cartItem.getCartId());
//		Optional<Carts> cart=cartRepository.findById(cartItem.getCartId());
		
		Double cartItemPrice=product.getPrice()*cartItem.getQuantity();
		CartItems newCartItem=new CartItems(cartItem.getQuantity(),cartItemPrice,cart,product);
		
		cart.setTotalPrice(cart.getTotalPrice()+cartItemPrice);
		cart.setCartItems(newCartItem);// Newly Added
		product.setStock(product.getStock()-cartItem.getQuantity());
		cart.setTotalItems(cart.getTotalItems()+cartItem.getQuantity());
		
		return mapper.map(cartItemsRepository.save(newCartItem), CartItemRespDTO.class); 
	}

	@Override
	public Set<CartItems> getCartItems(Long CartId) {
		Carts cart=cartRepository.getReferenceById(CartId);
		
		return  cart.getCartItems();
	}

	@Override
	public void DeleteCartItemsFromCart(Carts cartId) {
		cartItemsRepository.deleteByCartId(cartId);	
	}
	
	
	
	
}
