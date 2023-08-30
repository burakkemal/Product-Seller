package com.sha.springbootproductseller.repository;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);

    @Modifying
    @Query("update User set role = :role where userName = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);


}
