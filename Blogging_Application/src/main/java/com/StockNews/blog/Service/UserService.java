package com.StockNews.blog.Service;

import java.util.List;

import com.StockNews.blog.Payloads.UserDTO;

public interface UserService {

	UserDTO createuser(UserDTO userDTO);
	
	UserDTO updateuser(UserDTO userDTO, int id);
	
	UserDTO getbyid(int id);
	
	List<UserDTO> getalluder();
	
	void deleteuser(int id);
	
	
}
