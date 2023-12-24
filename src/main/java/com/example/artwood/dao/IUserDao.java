package com.example.artwood.dao;

import com.example.artwood.entities.User;

public interface IUserDao {
    User authenticateUser(String email, String password);

}