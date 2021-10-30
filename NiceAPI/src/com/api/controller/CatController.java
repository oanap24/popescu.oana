package com.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.model.Cat;

@Controller
public class CatController {
	@GetMapping("/getCats")
	    public String getCats() {
		 //new Cat("Tucci",1,"Scottish");
		  return "Tucci";
				 
	    }
}	
