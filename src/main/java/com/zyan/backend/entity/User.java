package com.zyan.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String token;
    @Column(name="created_at")
    private java.time.ZonedDateTime createdAt;
    @Column(name="updated_at")
    private java.time.ZonedDateTime updatedAt;
}
