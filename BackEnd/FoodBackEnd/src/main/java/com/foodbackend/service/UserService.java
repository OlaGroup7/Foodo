package com.foodbackend.service;

@Service
public class UserService {

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
