package com.tekarch.usermanagementms.Models;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(unique = true, nullable = false,length = 50)
    private String username;

    @Column(unique = true, nullable = false,length = 100)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Column(unique = true, nullable = true,length = 15)
    private String phone_number;

    /*@Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean two_factor_enabled;*/

    @Column(nullable=false)
    private boolean two_factor_enabled=false;

    @Column(length = 20)
    private String kyc_status="pending";

    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at = LocalDateTime.now(); // when the user profile was created

    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now(); // when the user profile was last updated

    // Adding DOB and gender fields for user's personal info endpoints
    @Column(nullable= true)
    private LocalDate DOB;

    @Column(nullable = true,length = 12)
    private String gender;

    //Adding document type and document id fields for kyc endpoints
    @Column(nullable=true)
    private String document_type;

    @Column(nullable=true)
    private String document_id;
}
