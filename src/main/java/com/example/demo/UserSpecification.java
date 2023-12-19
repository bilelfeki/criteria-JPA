package com.example.demo;

import com.example.demo.entities.User;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<User> {
  private SearchCriteria criteria;

  public UserSpecification(SearchCriteria criteria) {
    this.criteria = criteria;
  }

  @Override
  public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    query.distinct(true);
    List<Order> orderList = new ArrayList<>();
    orderList.add(criteriaBuilder.asc(root.get("servers.serverName")));
    orderList.add(criteriaBuilder.asc(root.get("email")));

    query.orderBy(orderList);
    return criteriaBuilder.equal(root.get("email"), "semi@gmail.com");
  }
}
