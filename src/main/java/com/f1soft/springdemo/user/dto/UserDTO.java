package com.f1soft.springdemo.user.dto;

import com.f1soft.springdemo.user.Role;
import lombok.Data;

import java.util.List;

/**
 * @author Rabina
 */

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String password;
    private  List<Integer> roleId;


    private AppointmentDTO profile;

    @Data
    public static class AppointmentDTO {
        private Long appointNo;
    }


}
