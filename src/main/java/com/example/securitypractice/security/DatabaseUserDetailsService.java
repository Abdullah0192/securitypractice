/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.securitypractice.security;
import com.example.securitypractice.repository.UserRepository;
import com.example.securitypractice.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class DatabaseUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;
    public DatabaseUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User "+username+" not found"));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
    }
}
