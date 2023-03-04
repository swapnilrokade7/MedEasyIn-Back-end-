package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dto.DeliveryAddressDTO;
import com.app.dto.OrdersRespDTO;
import com.app.entities.Orders;

public interface OrderService {

	OrdersRespDTO placeOrder(Long userId,DeliveryAddressDTO address);

	List<Orders> getAllOrders();

	List<Orders> getMyOrders(Long Id);

	void deleteOrder(Long orderId);
	
}
