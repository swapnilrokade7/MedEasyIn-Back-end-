package com.app.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UsersDTO;
import com.app.entities.Carts;
import com.app.entities.Users;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UsersDTO addUserDetails(UsersDTO user) {
		Users trueUser = new Users(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRole(), user.getMobile_number()); 
		Users addeduser =userRepo.save(trueUser);
		Carts cart=cartService.addCart(addeduser);
		addeduser.setCart(cart);
		return mapper.map(addeduser, UsersDTO.class);
	}
	

}
