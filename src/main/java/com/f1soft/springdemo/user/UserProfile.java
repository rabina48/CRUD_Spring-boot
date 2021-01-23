package com.f1soft.springdemo.user;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

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


//    @JoinTable(name = "user_appointment",
//            joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "appointment_id"))
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )


  //private List<AppointmentProfile> profile;



}
