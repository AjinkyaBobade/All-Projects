package com.StockNews.blog.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockNews.blog.Payloads.ApiResponse;
import com.StockNews.blog.Payloads.UserDTO;
import com.StockNews.blog.Service.UserService;





@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	//Post User
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		
		UserDTO createuser = this.userService.createuser(userDTO);
		
		
		return new ResponseEntity<>(createuser,HttpStatus.CREATED);
		
		
	}
	
	//Update User
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateuser(@RequestBody UserDTO userDTO,@PathVariable int id){
		
		UserDTO updateduser = this.userService.updateuser(userDTO, id);
		
		
		return new ResponseEntity<UserDTO>(updateduser,HttpStatus.OK);
		
		
	}
	//Delete User
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse> deleteuser(@PathVariable int id){
		//return this.deleteuser(id);
		
		this.deleteuser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user Deleted Sucessfully",true),HttpStatus.OK);
		
		
	}
	//Get Users

	
}
