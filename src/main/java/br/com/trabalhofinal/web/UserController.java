package br.com.trabalhofinal.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController 
public class UserController {	
			
    @GetMapping("/user")
    public String getUser(){
    	String str = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    	String nome = str.split(" ")[2].replaceAll(";","");
    	
    	return nome;
    }   
    
}
