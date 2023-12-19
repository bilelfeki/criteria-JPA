package com.example.demo.controllers;

import com.example.demo.SearchCriteria;
import com.example.demo.UserSpecification;
import com.example.demo.entities.Server;
import com.example.demo.entities.ServerRepo;
import com.example.demo.entities.User;
import com.example.demo.entities.UserRepo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/criteria")
@RestController
public class CriteriaController {

  private final UserRepo userRepo;
  private final ServerRepo serverRepo;

  public CriteriaController(UserRepo userRepo, ServerRepo serverRepo) {
    this.userRepo = userRepo;
    this.serverRepo = serverRepo;
  }

  @GetMapping
  public List<User> getAllUser() {


    return this.userRepo.findAll();
  }

  @PostMapping
  public void saveStatically() {


    User user1 = new User("bilelfeki", "bilel@gmail.com");
    user1=userRepo.save(user1);
    Server server1 = new Server("apashe",user1);

    User user2 = new User("semi", "semi@gmail.com");
    user2=userRepo.save(user2);
    Server server2 = new Server("nginx",user2);



    Server server3 = new Server("nginx",user1);

    serverRepo.saveAll(List.of(server1, server2,server3));
  }

  @GetMapping("/execute")
  private List<User> executeCriteria() {
    UserSpecification userSpecification = new UserSpecification(new SearchCriteria("email", ">", "null"));
    List<User> users = userRepo.findAll(Specification.where(userSpecification));
    return users;
  }
}
