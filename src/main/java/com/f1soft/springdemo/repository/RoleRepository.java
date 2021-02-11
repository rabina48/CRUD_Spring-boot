package com.f1soft.springdemo.repository;

import com.f1soft.springdemo.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
