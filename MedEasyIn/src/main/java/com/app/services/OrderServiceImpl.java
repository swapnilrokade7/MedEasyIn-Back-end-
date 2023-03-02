package com.app.services;

import java.time.LocalDate;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DeliveryAddressDTO;
import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.DeliveryAddress;
import com.app.entities.OrderDetails;
import com.app.entities.Orders;
import com.app.entities.Status;
import com.app.entities.Users;
import com.app.repository.AddressRepository;
import com.app.repository.OrderDetailsRepository;
import com.app.repository.OrderRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
    private OrderDetailsRepository detailsRepository;
	

	@Override
	public Orders placeOrder(Long userId,DeliveryAddressDTO address) {
		DeliveryAddress trueAddress=new DeliveryAddress(address.getAdress_Line1(),address.getAdress_Line2(),address.getCity(),address.getState(),address.getZipCode());
		DeliveryAddress addedAddress=addressRepository.save(trueAddress);
		Users user=userRepository.getReferenceById(userId);
		Orders order=new Orders( LocalDate.now(),LocalDate.now(), Status.PLACED, 0, 40 , user, addedAddress);
		Orders neworder=orderRepository.save(order);
		addedAddress.setOrderInfo(neworder);
		Carts cart=user.getCart();
		Set<CartItems> cartItems=user.getCart().getCartItems();
		cartItems.forEach(x->{
			OrderDetails oDetails = new OrderDetails(x.getQuantity() , x.getTotalPrice(),neworder,x.getProductId());
			System.out.println(oDetails);
            neworder.setOrderDetails(detailsRepository.save(oDetails));
            
		});
		neworder.setTotalPrice(cart.getTotalPrice()+neworder.getShippingPrice());
//		neworder.setStatus(Status.PLACED);
		//cart.setCartItems(null);
		//Repo Delete method Call for CartItems (Death of Cart is Birth Of Order)
		
		
		return  neworder;
	}
	
	
	

}
