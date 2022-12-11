package com.example.complaintApp_Backend.dao;

import com.example.complaintApp_Backend.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Userdao extends CrudRepository<UserInfo,Integer> {
@Query(value = "SELECT `id`, `address`, `email`, `mobile`, `name`, `password`, `username` FROM `userinfo` WHERE `username` = :username AND `password`= :password",nativeQuery = true)
    List<UserInfo> UserLogin(@Param("username") String username, @Param("password") String password);

@Query(value = "SELECT `id`, `address`, `email`, `mobile`, `name`, `password`, `username` FROM `userinfo` WHERE `username` = :username",nativeQuery = true)
    List<UserInfo> FindUser(@Param("username") String username);
}
