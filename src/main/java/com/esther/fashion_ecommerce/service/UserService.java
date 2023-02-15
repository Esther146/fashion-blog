package com.esther.fashion_ecommerce.service;

import com.esther.fashion_ecommerce.exception.UserNotFoundException;
import com.esther.fashion_ecommerce.model.User;
import com.esther.fashion_ecommerce.payload.LoginDto;
import com.esther.fashion_ecommerce.payload.UserDto;
import com.esther.fashion_ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public User createUser(UserDto userDto){

        if(checkEmail(userDto.getEmail())){
            throw new UserNotFoundException("The user with the email already exists");
        }

        User newUser = new User();


        newUser.setFirstname(userDto.getFirstname());
        newUser.setLastname(userDto.getLastname());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        newUser.setPhoneNumber(userDto.getPhoneNumber());

        return userRepository.save(newUser);
    }
     boolean checkEmail(String email){
       return userRepository.existsByEmail(email);

     }

     public String login(LoginDto loginDto){
        Optional<User> checkEmail = userRepository.findByEmail(loginDto.getEmail());

        if (checkEmail.isPresent()){

            User user = checkEmail.get();
            if (user.getPassword().equals(loginDto.getPassword())){
                return "SuccessFull";
            } else {
                throw new UserNotFoundException("Incorrect email or password");
            }

        } else {
            throw new UserNotFoundException("User does not exist");
        }
     }



    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()){

            throw new UserNotFoundException("The user with this  id: {" + id + "} not found");
        }
        return findUser.get();
    }


    public User updateUser(Long id, UserDto userDto){
        Optional<User> currentUser = userRepository.findById(id);

        if(currentUser.isEmpty()){
            throw new UserNotFoundException("The user with the id: {" + id + "}not found");
        } else {

            User user = userRepository.findById(id).get();

            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setPhoneNumber(userDto.getPhoneNumber());
            return userRepository.save(user);
        }
    }

    public void deleteUserById(Long id){
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()){

            throw new UserNotFoundException("The user with the id: {" + id + "}not found");
        }
        userRepository.deleteById(id);
    }

}
