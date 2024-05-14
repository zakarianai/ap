package org.parking.gestio_parking.Dto;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.entities.Compte;
import org.parking.gestio_parking.entities.Parking;

@Data

public class AdminDto {
    private int adminId;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String address;
    private String username;
    private String email;
    private String password;


}
