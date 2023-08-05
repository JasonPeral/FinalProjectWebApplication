package com.finalProject.DistributionCenterManager.controllers;

import com.finalProject.DistributionCenterManager.models.User;
import com.finalProject.DistributionCenterManager.models.registrationForm.RegistrationForm;
import com.finalProject.DistributionCenterManager.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class Register {

    @Autowired
    UserRepository userRepository;

//    PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

//        User user = form.toUser(passwordEncoder);

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);

    }
}
