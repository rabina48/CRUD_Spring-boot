package com.f1soft.springdemo.user;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class    Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String name;

//    @ManyToMany(mappedBy = "roles")
//    private List<UserProfile> userProfileList;
}
