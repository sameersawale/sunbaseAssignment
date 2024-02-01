package com.example.sunbaseAssignment.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;
@Entity
@Table(name = "customer")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uuid= UUID.randomUUID().toString();

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String state;

    private String email;

    private String phone;

}
