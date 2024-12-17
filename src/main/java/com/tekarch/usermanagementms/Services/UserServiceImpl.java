package com.tekarch.usermanagementms.Services;

import com.tekarch.usermanagementms.Exceptions.UserNotFoundException;
import com.tekarch.usermanagementms.Models.User;
import com.tekarch.usermanagementms.Repositories.UserRepository;
import com.tekarch.usermanagementms.Services.Interfaces.UserService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public User addUser(User user) {
        logger.info("Creating new user::");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Retrieving all users::");
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long user_id) {
        logger.info("Retrieving specific user details by user ID");

        // Fetch the user from the database using the repository
        Optional<User> userOptional = userRepository.findById(user_id);

        return userOptional.orElseThrow(() -> new UserNotFoundException("User with ID " + user_id + " not found"));
    }

    @Override
    public void deleteUser(Long user_id) {
        //check if the user exists in the database
        Optional<User> userOptional = userRepository.findById(user_id);
        if(userOptional.isPresent())
        {
            userRepository.deleteById(user_id);
        }
        else {
            throw new UserNotFoundException("User with ID " + user_id + "not found");
        }
    }

    @Override
    public User updateUser(Long user_id, User userData) {

        Optional<User> userOptional = userRepository.findById(user_id);

        if(userOptional.isPresent())
        {
            User existingUser = userOptional.get();
            existingUser.setUsername(userData.getUsername());
            existingUser.setEmail(userData.getEmail());
            existingUser.setPhone_number(userData.getPhone_number());
            return userRepository.save(existingUser);
        }
        else {
            throw new RuntimeException("User not found with id: "+ user_id);
        }
    }

    // It is same as getuser, do we need to have separate endpoint?
    @Override
    public User getUserPersonalInfo(Long user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        return userOptional.orElseThrow(() -> new UserNotFoundException("User with ID " + user_id + " not found"));
    }

    @Override
    public User updateUserPersonalInfo(Long user_id, User userData) {
        Optional<User> userOptional = userRepository.findById(user_id);

        if(userOptional.isPresent())
        {
            User existingUser = userOptional.get();
            existingUser.setDOB(userData.getDOB());
            existingUser.setGender(userData.getGender());
            return userRepository.save(existingUser);
        }
        else {
            throw new RuntimeException("User not found with id: "+ user_id);
        }
    }
    //KYC endpoints
    @Override
    public User submitKyc(Long user_id, User userData) {
        logger.info("Submitting user kyc documents::");
        return userRepository.save(userData);
    }

    @Override
    public User getUserKyc(Long user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if(userOptional.isPresent())
        {
            User existingUser = userOptional.get();
            existingUser.getDocument_id();
            existingUser.getDocument_type();
            return existingUser;
        }
        else
        return userOptional.orElseThrow(() -> new UserNotFoundException("User with ID " + user_id + " not found"));
    }

    @Override
    public User updateUserKyc(Long user_id, User userData) {
        Optional<User> userOptional = userRepository.findById(user_id);

        if(userOptional.isPresent())
        {
            User existingUser = userOptional.get();
            existingUser.setDocument_id(userData.getDocument_id());
            existingUser.setDocument_type(userData.getDocument_type());
            return userRepository.save(existingUser);
        }
        else {
            throw new RuntimeException("User not found with id: "+ user_id);
        }
    }

    @Override
    public void deleteUserKyc(Long user_id) {
         userRepository.deleteById(user_id);
        //check if the user exists in the database
        /*Optional<User> userOptional = userRepository.findById(user_id);
        if(userOptional.isPresent())
        {
            User existingUser = userOptional.get();
            existingUser.setDocument_type(userOptional
                    userRepository.delete
        }
        else {
            throw new UserNotFoundException("User with ID " + user_id + "not found");
        }*/

    }

}

