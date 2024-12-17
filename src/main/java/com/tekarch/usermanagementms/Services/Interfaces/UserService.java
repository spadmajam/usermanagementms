package com.tekarch.usermanagementms.Services.Interfaces;

import com.tekarch.usermanagementms.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //User endpoints
    User addUser(User user);
    List<User> getAllUsers();
    User getUser(Long user_id);
    void deleteUser(Long user_id);
    User updateUser(Long user_id,User userData);
    //User personal info endpoints
    User getUserPersonalInfo(Long user_id);
    User updateUserPersonalInfo(Long user_id, User userData);
    //KYC endpoints
    User submitKyc(Long user_id,User userData);
    User getUserKyc(Long user_id);
    User updateUserKyc(Long user_id,User userData);
    void deleteUserKyc(Long user_id);
}
