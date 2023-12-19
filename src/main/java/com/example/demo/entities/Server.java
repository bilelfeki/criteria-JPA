package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Server {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String serverName;
  @ManyToOne
  private User user;

  public Server(String serverName, User user) {
    this.serverName = serverName;
    this.user = user;
  }

  public Server(String serverName) {
    this.serverName = serverName;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Server() {
  }
}
