package com.sha.springbootproductseller.security;

import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.service.UserService;
import com.sha.springbootproductseller.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user= userService.findByUserName(username).orElseThrow(()->new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities=Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrinciple.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities(authorities)
                .build();

    }
}
