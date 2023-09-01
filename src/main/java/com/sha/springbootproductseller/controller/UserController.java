package com.sha.springbootproductseller.controller;


import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.security.UserPrinciple;
import com.sha.springbootproductseller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user") //pre-path
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("change/{role}") //api/user/change/{role}
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple, @PathVariable Role role){
        userService.changeRole(role,userPrinciple.getUsername());
        return ResponseEntity.ok(true);
    }
}
