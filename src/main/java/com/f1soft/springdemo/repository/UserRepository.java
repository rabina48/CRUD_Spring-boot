package com.f1soft.springdemo.repository;

import com.f1soft.springdemo.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserProfile, Integer> {

}
