package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.DeliveryAddress;
import com.app.entities.Orders;

public interface AddressRepository extends JpaRepository<DeliveryAddress, Long>{
	void deleteByorderInfo(Orders id);

}
