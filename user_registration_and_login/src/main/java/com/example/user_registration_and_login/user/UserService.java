package com.example.user_registration_and_login.user;

import com.example.user_registration_and_login.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;
    private EmailService emailSenderService;;
    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException{
        final Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found",email));

        }
    }

    void signUpUser(User user){
        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        final User createdUser = userRepository.save(user);
        final ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        sendConfirmationMail(user.getEmail(), confirmationToken.getConfirmationToken());

    }

    void confirmUser(ConfirmationToken confirmationToken){
        final User user = confirmationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());
    }

    void sendConfirmationMail(String userMail, String token){
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<rs.agarwal@gmail.com>");
        mailMessage.setText("Thank you for registering. Please click on the below link to activate your account. " +
                "http://localhost:8080/sign-up/confirmation?token="+token );

        emailSenderService.sendEmail(mailMessage);

    }
}

