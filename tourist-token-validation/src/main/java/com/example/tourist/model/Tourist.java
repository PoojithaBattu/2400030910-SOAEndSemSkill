package com.example.tourist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tourists")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String country;
    private String destination;

    public Tourist() {}

    public Tourist(String name, String email, String country, String destination) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.destination = destination;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
}
