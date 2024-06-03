package org.example.thatfamiliarforum.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;


public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private LocalDate creationDate;

}
