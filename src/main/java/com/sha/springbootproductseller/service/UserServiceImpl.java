package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void changeRole(Role newRole, String userName){
        userRepository.updateUserRole(userName,newRole);
    }

}
