package com.example.demo;

import com.example.demo.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification implements Specification<User> {
  private SearchCriteria criteria;

  public UserSpecification(SearchCriteria criteria) {
    this.criteria = criteria;
  }

  @Override
  public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    System.out.println(root.get("email"));
    if(criteria.getOperation().equalsIgnoreCase(">")){
      System.out.println("after");
      System.out.println(query.getParameters());
      return criteriaBuilder.equal(
      root.get("email"),"semi@gmail.com");
    }
    return null;
  }
}
