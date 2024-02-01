package com.example.sunbaseAssignment.Controller;

import com.example.sunbaseAssignment.DTO.CustomerDTO;
import com.example.sunbaseAssignment.DTO.SearchByName;
import com.example.sunbaseAssignment.DTO.UpdateDto;
import com.example.sunbaseAssignment.Model.Customer;
import com.example.sunbaseAssignment.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer=customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCustomerList(){
        List<Customer> customerList=customerService.customerList();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") int id){
        Customer customer=customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") int id, @RequestBody UpdateDto updateDto){
        Customer customer=customerService.updateCustomer(id, updateDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id){
        String result=customerService.deleteCustomer(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByFirstName(@RequestBody SearchByName searchByName){
        List<Customer> customerList=customerService.searchByFirstName(searchByName);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

}
