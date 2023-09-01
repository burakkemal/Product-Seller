package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.security.UserPrinciple;
import com.sha.springbootproductseller.security.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationService{

    public final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJwt(User signInRequest){
        Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(signInRequest.getUserName(),signInRequest.getPassword())
        );
        UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
        String jwt=jwtProvider.generateToken(userPrinciple);

        User signInUser=userPrinciple.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
}
