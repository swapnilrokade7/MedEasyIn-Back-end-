package com.app.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ElementAlreadyExistsException;
import com.app.custom_exception.ElementNotFoundException;
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
	private CartItemsService cartItemsService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UsersDTO addUserDetails(UsersDTO user) {
		Users trueUser = new Users(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRole(), user.getMobile_number()); 
		Users checkUser=userRepo.findByEmail(user.getEmail());
		if(checkUser!=null) {
			throw new ElementAlreadyExistsException("User ", "403", "User ALready Exist");
		}
		
		Users addeduser =userRepo.save(trueUser);
		Carts cart=cartService.addCart(addeduser);
		addeduser.setCart(cart);
		return mapper.map(addeduser, UsersDTO.class);
		
		
		
		
	}

	@Override
	public String deleteUserDetails(Long userId) {
		Users user=userRepo.findById(userId).orElseThrow(()-> new ElementNotFoundException("User", "404", "Not Found"));
		cartItemsService.DeleteCartItemsFromCart(user.getCart());
		userRepo.deleteById(userId);
		return "User is Deleted";
	}

	@Override
	public Users updateUserDetails(UsersDTO user) {
		Users oldUser=userRepo.findByEmail(user.getEmail());
		if(oldUser==null) {
			throw new ElementNotFoundException("User", "404", "Not Found");
		}
		BeanUtils.copyProperties(user, oldUser);
		return oldUser;
	}
	

}
