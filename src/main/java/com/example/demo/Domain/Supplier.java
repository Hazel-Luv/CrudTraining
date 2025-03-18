package com.example.demo.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String address;
    private String contactNumber;
    @Column(name = "emailAddress")
    private String email;

  }

