package com.foodbackend.service;

import com.foodbackend.model.*;
import com.foodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    String pepper = "qwerty1234";
    @Autowired
    UserRepository userRepository;

    public HomePageUserDetails fetchUserHomePageDetails(long userID)
    {
        HomePageUserDetails homePageUserDetails = new HomePageUserDetails(); //need to add the jpa methods like findbyID to fetch name and address
        return homePageUserDetails;
    }

    public SignUpResponse register(User user){
        SignUpResponse signUpResponse = new SignUpResponse();
        User currentuser = userRepository.findByEmail(user.getEmail());
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
            signUpResponse.setFlag(true);
            signUpResponse.setMsg("Signup Successful!!");
            return signUpResponse;
        }
    }

    public LoginResponse authenticate(LoginRequest loginRequest)
    {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();


        if(user ==  null)
        {
            loginResponse.setFlag(false);
            loginResponse.setMsg("User not found! Invalid Email");
        }
        else if(user.getPassword().equals(BCrypt.hashpw(loginRequest.getPassword()+pepper,user.getSalt()))){
            loginResponse.setFlag(true);
            loginResponse.setMsg("login successful");
            loginResponse.setUserID(user.getUserID());
            loginResponse.setRole(user.getRole());
        }
        else {
            loginResponse.setFlag(false);
            loginResponse.setMsg("Invalid Password");
        }
        return loginResponse;
    }
}
