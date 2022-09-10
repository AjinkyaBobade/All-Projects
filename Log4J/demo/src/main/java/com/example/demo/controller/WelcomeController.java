package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private static Logger log=LoggerFactory.getLogger(WelcomeController.class);
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
			log.debug("welocme() method execution started");
			String msg="Welcome to BikkadIt";
			log.debug("welocme() method execution ended");
			log.info("welcome() method executed successfully");
			return msg;
		
	}

}
