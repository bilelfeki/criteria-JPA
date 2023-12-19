package com.example.demo.controllers;

import com.example.demo.SearchCriteria;
import com.example.demo.UserSpecification;
import com.example.demo.entities.User;
import com.example.demo.entities.UserRepo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@RequestMapping("/criteria")
@RestController
public class CriteriaController {

  private final UserRepo userRepo;

  public CriteriaController(UserRepo userRepo) {
    this.userRepo = userRepo;
  }
  @GetMapping
  public List<User> getAllUser(){


    return this.userRepo.findAll();
  }
  @PostMapping
  public void saveStatically(){
    User user1=new User("bilelfeki","bilel@gmail.com");
    User user2=new User("semi","semi@gmail.com");
    userRepo.saveAll(List.of(user2,user1));
  }
  @GetMapping("/execute")
  private List<User> executeCriteria(){
    UserSpecification userSpecification=new UserSpecification(new SearchCriteria("email",">","null"));
    List<User> users = userRepo.findAll(Specification.where(userSpecification));
    return users;
  }
}
