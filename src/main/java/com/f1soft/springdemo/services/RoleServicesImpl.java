package com.f1soft.springdemo.services;

import com.f1soft.springdemo.repository.RoleRepository;
import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;

import com.f1soft.springdemo.user.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServicesImpl implements RoleServices {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public BaseResponse updateRole(int roleId, Role role) {
        Optional<Role> data = roleRepository.findById(role.getId());

        if(data.isPresent()){
            Role roles = data.get();
            roles.setName(role.getName());
            return new BaseResponse(200, true, "success",roleRepository.save(roles));
        }else{
            return new BaseResponse(404, false, "unsuccess");
        }

    }

    @Override
    public Response deleteRole(int roleId) {
        Optional<Role> data = roleRepository.findById(roleId);
        if(data.isPresent()){
            roleRepository.deleteById(roleId);
            return new BaseResponse(200, true, "Delete success");
        }else{
            return new BaseResponse(404, false, "unsuccess");
        }

    }

    @Override
    public BaseResponse getAllRole() {
        List<Role> allRole = roleRepository.findAll();
        return new BaseResponse(200, true, "Success", allRole);
    }

    @Override
    public BaseResponse roleAdd(Role roleDTO) {

        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());

        return new BaseResponse(200, true, "success",roleRepository.save(role));

    }
}
