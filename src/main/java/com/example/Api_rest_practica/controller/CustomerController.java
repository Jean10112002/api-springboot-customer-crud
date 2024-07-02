package com.example.Api_rest_practica.controller;

import com.example.Api_rest_practica.model.Customer;
import com.example.Api_rest_practica.model.dto.CustomerDto;
import com.example.Api_rest_practica.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public ResponseEntity<?> getAllCustomer(){
        try{
            List<Customer> customer=customerService.getALLCustomer();
            return ResponseEntity.ok().body(customer);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Customer customer= customerService.findById(id);
            if(customer==null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(CustomerDto.builder().id(customer.getId()).phone(customer.getPhone()).documentNumber(customer.getDocumentNumber()).documentType(customer.getDocumentType()).name(customer.getName()).build());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e);
        }

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customer){
        try {
            Customer customerSave= customerService.saveCustomer(customer);
            return ResponseEntity.ok().body(customerSave);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(customer);
        }
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Customer updateCustomer(@RequestBody CustomerDto customer){
        return customerService.saveCustomer(customer);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
         customerService.deleteCustomer(id);
    }


}
