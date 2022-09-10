package com.StockNews.blog.Service.Impl;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import com.StockNews.blog.Exceptions.*;
import org.springframework.stereotype.Service;

import com.StockNews.blog.Model.User;
import com.StockNews.blog.Payloads.UserDTO;
import com.StockNews.blog.Repository.UserRepository;
import com.StockNews.blog.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDTO createuser(UserDTO userDTO) {
		
		User user = this.DetoToUser(userDTO);
		User save = this.userRepository.save(user);
		
		return this.UserToDto(save);
	}

	@Override
	public UserDTO updateuser(UserDTO userDTO, int id) {
		//Try Self Exception Handling
		User user=this.userRepository.findById(id)
				.orElseThrow(()-> new ResourcenotFoundException("User","Id",id));
		
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		
		User UpdatedUser = this.userRepository.save(user);
		
		UserDTO userToDto1 = this.UserToDto(UpdatedUser);
		
		return userToDto1;
	}

	@Override
	public UserDTO getbyid(int id) {
		
		User user=this.userRepository.findById(id)
				.orElseThrow(()-> new ResourcenotFoundException("User","Id",id));
		
		
		return this.UserToDto(user);
	}

	@Override
	public List<UserDTO> getalluder() {
		
		 List<User> users = this.userRepository.findAll();
		Stream<User> stream = users.stream();
		List<UserDTO> allusers = stream.map(user->this.UserToDto(user)).collect(Collectors.toList());
		
		 
		 return allusers;
		
	}

	@Override
	public void deleteuser(int id) {
		
		User user = this.userRepository.findById(id)
				.orElseThrow(()->new ResourcenotFoundException("User","Id",id));
		this.userRepository.delete(user);
		
		
	}
	
	public User DetoToUser(UserDTO userDTO) {
		
		User user=new User();
		
		user.setId(userDTO.getId());
		
		user.setName(userDTO.getName());
		
		user.setPassword(userDTO.getPassword());
		
		user.setAbout(userDTO.getAbout());
		
		return user;
		
		
		
	}
	
	
	public UserDTO UserToDto(User user) {
		
		UserDTO userDTO=new UserDTO();
		
		userDTO.setId(user.getId());
		
		userDTO.setName(user.getName());
		
		userDTO.setPassword(user.getPassword());
		
		userDTO.setAbout(user.getAbout());
		
		return userDTO;
		
		
	}

	
}
