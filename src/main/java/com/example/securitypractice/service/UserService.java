package com.example.securitypractice.service;
import com.example.securitypractice.repository.UserRepository;
import com.example.securitypractice.security.JwtService;
import com.example.securitypractice.dto.RegisterRequest;
import com.example.securitypractice.entity.User;
import com.example.securitypractice.dto.LoginRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    public User registerUser(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encodedPassword);
        user.setRole("USER");
        return userRepository.save(user);
    }
    
    public String login(LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("Invalid username or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid username or password");
        }
        return jwtService.generateToken(user.getUsername());
    }
}
