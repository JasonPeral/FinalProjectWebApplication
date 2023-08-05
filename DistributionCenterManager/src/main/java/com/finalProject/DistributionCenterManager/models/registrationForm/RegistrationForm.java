package com.finalProject.DistributionCenterManager.models.registrationForm;

import com.finalProject.DistributionCenterManager.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    @NotBlank(message = "username can not be blank")
    private String username;
    @NotBlank(message = "password can not be blank")
    private String password;

//    public User toUser(PasswordEncoder passwordEncoder){
//        return User.builder()
//                .username(username)
//                .password(passwordEncoder.encode(password))
//                .build();
//
//    }
}
