package com.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long Id;

  String name;
  String email;

  @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
  private List<Server> servers;


  public User(String name, String email, List<Server> servers) {
    this.name = name;
    this.email = email;
    this.servers = servers;
  }

  public List<Server> getServers() {
    return servers;
  }

  public void setServers(List<Server> servers) {
    this.servers = servers;
  }

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
