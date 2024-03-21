package com.main.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WishMessageController 
{
	@Autowired
	private LocalDateTime ldt;
	
	 @GetMapping("/wish")
     public ResponseEntity<String> getWishMessage()
     {
    	int hour = ldt.getHour();
    	String msg = null;
    	if(hour<12)
    	{
    		msg = "Good Morning";
    	}
    	else if(hour<16)
    	{
    		msg = "Good Afternoon";
    	}
    	else if(hour<18)
    	{
    		msg = "Good Evening";
    	}
    	else
    		msg = "Good Night";
    	
    	return new ResponseEntity<String>(msg,HttpStatus.OK);
     }
}
