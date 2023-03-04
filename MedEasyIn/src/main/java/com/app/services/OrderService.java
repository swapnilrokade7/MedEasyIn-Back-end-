package com.app.services;

import java.util.List;

import com.app.dto.DeliveryAddressDTO;
import com.app.dto.OrdersRespDTO;
import com.app.entities.Orders;

public interface OrderService {

	OrdersRespDTO placeOrder(Long userId,DeliveryAddressDTO address);

	List<Orders> getAllOrders();
	
}
