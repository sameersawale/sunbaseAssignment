package com.example.sunbaseAssignment.Service;

import com.example.sunbaseAssignment.DTO.CustomerDTO;
import com.example.sunbaseAssignment.DTO.SearchByName;
import com.example.sunbaseAssignment.DTO.UpdateDto;
import com.example.sunbaseAssignment.Exception.UserNotFoundException;
import com.example.sunbaseAssignment.Model.Customer;
import com.example.sunbaseAssignment.Repository.CustomerRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer();

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        customerRepository.save(customer);

        return customer;
    }

    public List<Customer> customerList() {
        return customerRepository.findAll();
    }


    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }


    public String deleteCustomer(int id) {
        customerRepository.deleteById(id);
        return "customer deleted successfully.....";
    }

    public Customer updateCustomer(int id, UpdateDto updateDto) {
        Customer customer=customerRepository.findById(id).get();
        customer.setFirstName(updateDto.getFirstName());
        customer.setLastName(updateDto.getLastName());
        customer.setAddress(updateDto.getAddress());
        customer.setCity(updateDto.getCity());
        customer.setState(updateDto.getState());
        customer.setEmail(updateDto.getEmail());
        customer.setPhone(updateDto.getPhone());

        customerRepository.save(customer);

        return customer;
    }

    public List<Customer> searchByFirstName(SearchByName searchByName){
         List<Customer> customerList=customerRepository.findAll();
         List<Customer> customers=new ArrayList<>();
         for (Customer customer:customerList){
             if(customer.getFirstName().equals(searchByName.getFirstName())){
                 customers.add(customer);
             }
         }
        return customers;
    }
}
