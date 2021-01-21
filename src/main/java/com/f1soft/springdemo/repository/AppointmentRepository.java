package com.f1soft.springdemo.repository;

import com.f1soft.springdemo.user.AppointmentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rabina
 */

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentProfile, Integer> {
}
