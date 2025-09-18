package com.example.nexttravelbackend.service;


import com.example.nexttravelbackend.dto.UserDTO;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

    UserDTO getUserByEmail(String email);

    boolean updateUserRole(String email, String role);

    List<UserDTO> getAllUsers();

    boolean deleteUserByEmail(String email);
}''