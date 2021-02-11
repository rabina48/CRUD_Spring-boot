package com.f1soft.springdemo.services;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.Role;

import org.springframework.stereotype.Service;

@Service
public interface RoleServices {
     BaseResponse updateRole(int roleId, Role role);

     Response deleteRole(int roleId);

     BaseResponse getAllRole();

     BaseResponse roleAdd(Role roleDTO);
    }
