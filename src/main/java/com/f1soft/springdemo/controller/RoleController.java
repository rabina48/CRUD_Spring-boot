package com.f1soft.springdemo.controller;


import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.services.RoleServices;
import com.f1soft.springdemo.user.AppointmentProfile;
import com.f1soft.springdemo.user.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

@Autowired
private RoleServices roleServices;

    @PutMapping("{roleId}")
    public BaseResponse updateRole(@PathVariable int roleId, @RequestBody Role role) {
        return roleServices.updateRole(roleId, role);
    }

    @DeleteMapping("roleId")
    public Response deleteRole(@PathVariable int roleId) {
        return roleServices.deleteRole(roleId);
    }



    @GetMapping("all")
    public BaseResponse getAllRole() {
        return roleServices.getAllRole();
    }


    @PostMapping("add")
    public BaseResponse addRole(@RequestBody Role roleDTO) {
        return roleServices.roleAdd( roleDTO);
    }
}
