package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long Id;

  String name;
  String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }
  public User() {

  }

  public Long getId() {
    return Id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
