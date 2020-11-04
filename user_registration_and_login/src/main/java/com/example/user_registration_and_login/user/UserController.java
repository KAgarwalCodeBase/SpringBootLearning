package com.example.user_registration_and_login.user;

import com.example.user_registration_and_login.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    String singIn(){

        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUpUser(User user)
    {
        return "sign-up";
    }


    @PostMapping("/sign-up")
    String signUp(User user)
    {
        userService.signUpUser(user);
        return "redirect:/sign-in";
    }

    @GetMapping("/sign-in/confirm")
    String confirmMail(@RequestParam("token") String token){
        Optional<ConfirmationToken> optionalConfirmationToken =
                confirmationTokenService.findConfirmationTokenByToken(token);
        optionalConfirmationToken.ifPresent(userService::confirmUser);
        return "home";
    }

}
