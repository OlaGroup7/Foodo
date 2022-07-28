package com.foodbackend.service;

import com.foodbackend.model.*;
import com.foodbackend.repository.FoodRepository;
import com.foodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    String pepper = "qwerty1234";
    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;

    public HomePageUserDetails fetchUserHomePageDetails(String _id)
    {
        HomePageUserDetails homePageUserDetails = new HomePageUserDetails();
        User user = userRepository.findBy_id(_id);
        homePageUserDetails.setName(user.getName());
        homePageUserDetails.setAddress(user.getAddress());
        //need to add the jpa methods like findbyID to fetch name and address
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
            User tempuser = userRepository.findByEmail(user.getEmail());
            signUpResponse.setFlag(true);
            signUpResponse.setMsg("Signup Successful!!");
            signUpResponse.set_id(tempuser.get_id());
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
            loginResponse.setRole(user.getRole());
            loginResponse.set_id(user.get_id());
        }
        else {
            loginResponse.setFlag(false);
            loginResponse.setMsg("Invalid Password");
        }
        return loginResponse;
    }

    public FoodResponse addfood(Food food){
        FoodResponse foodResponse = new FoodResponse();
        foodRepository.save(food);
        foodResponse.setStatus(true);
        foodResponse.setMessage("Food Addition successful");
        return foodResponse;
    }

    public ArrayList<Food> fetchlist(String _id, String cuisine){
        ArrayList<Food> foods = foodRepository.findByRestaurantIDAndCuisineType(_id,cuisine);

        return foods;
    }
}
