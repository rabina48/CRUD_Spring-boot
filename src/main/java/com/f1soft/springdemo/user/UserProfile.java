package com.f1soft.springdemo.user;
import lombok.Data;
import sun.security.util.Password;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_info")

public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long phone;
    private String  password;

}
