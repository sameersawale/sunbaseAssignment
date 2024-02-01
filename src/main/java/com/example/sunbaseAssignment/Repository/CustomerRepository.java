package com.example.sunbaseAssignment.Repository;

import com.example.sunbaseAssignment.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(String firstName);


}
