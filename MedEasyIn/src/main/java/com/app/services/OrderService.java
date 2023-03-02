package com.app.services;

import com.app.dto.DeliveryAddressDTO;
import com.app.entities.Orders;

public interface OrderService {

	Orders placeOrder(Long userId,DeliveryAddressDTO address);
	
}
