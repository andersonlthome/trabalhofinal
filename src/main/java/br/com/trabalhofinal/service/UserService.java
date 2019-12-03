package br.com.trabalhofinal.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.trabalhofinal.model.User;
import br.com.trabalhofinal.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
