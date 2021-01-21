package com.f1soft.springdemo.user;

import com.f1soft.springdemo.logging.TrackExecutionTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Rabina
 */

@Data
@Entity
@Table(name = "appointment_profile")
public class AppointmentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date datee;

    private long appointNo;

}
