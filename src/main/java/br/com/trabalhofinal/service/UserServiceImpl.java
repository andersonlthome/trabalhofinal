package br.com.trabalhofinal.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.model.Role;
import br.com.trabalhofinal.model.User;
import br.com.trabalhofinal.repository.UserRepository;
import br.com.trabalhofinal.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        try {   
        	user.setName(registration.getName());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user.setRoles(Arrays.asList(new Role("ROLE_USER")));        
        	user.setdateB(registration.getdateB());
        	user.setSex(registration.getSex());
            user.setLogradouro(registration.getLogradouro());
            user.setNumber(registration.getNumber());
            user.setComplemento(registration.getComplemento());
            user.setCidade(registration.getCidade());
            user.setUF(registration.getUF());
            user.setCep(registration.getCep());
        } catch(Exception e) {
        	System.out.println("error:"+e);
        }    
        
        return userRepository.save(user);
    }

    //@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return (Collection<? extends GrantedAuthority>) roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
