package com.example.demo.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo
    extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {

}
