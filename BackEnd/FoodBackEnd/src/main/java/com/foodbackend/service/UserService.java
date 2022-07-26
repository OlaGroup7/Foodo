package com.foodbackend.service;

import com.foodbackend.model.SignUpResponse;
import com.foodbackend.model.User;
import com.foodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserService {
    @Autowired
    UserRepository userRepository;
    public SignUpResponse register(User user){
        SignUpResponse signUpResponse = new SignUpResponse();
        User currentuser = userRepository.findByEmail(user.getEmail(),user.getPhone());
        if(currentuser != null){
            signUpResponse.setFlag(false);
            signUpResponse.setMsg("User already exists");
            return signUpResponse;
        }else{
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword()+pepper, salt);
            user.setPassword(hashedPassword);
            user.setSalt(salt);
            userRepository.save(user);
            signUpResponse.setStatus(true);
            signUpResponse.setMessage("Signup Successful!!");
            return signUpResponse;
        }
    }
}
