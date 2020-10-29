package com.example.user_registration_and_login.user;

import com.example.user_registration_and_login.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conformationToken;
    private LocalDate createDate;

    @OneToOne(targetEntity = User.class, fetch= FetchType.EAGER)
    @JoinColumn(nullable=false,name="user_id")
    private User user;

     ConfirmationToken(User user){
        this.user = user;
        this.createDate = LocalDate.now();
        this.conformationToken = UUID.randomUUID().toString();

    }


}
