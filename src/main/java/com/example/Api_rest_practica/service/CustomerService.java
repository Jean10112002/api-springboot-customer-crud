package com.example.Api_rest_practica.service;

import com.example.Api_rest_practica.model.Customer;
import com.example.Api_rest_practica.model.dto.CustomerDto;
import com.example.Api_rest_practica.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getALLCustomer( ){
        return (List<Customer>) customerRepository.findAll();
    }
    public Customer findById(Long id){
        return customerRepository.findById(id).orElse(null);
    }
    public Customer saveCustomer(CustomerDto customerDto){
        Customer customer=Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .documentNumber(customerDto.getDocumentNumber())
                .documentType(customerDto.getDocumentType())
                .phone(customerDto.getPhone())
                .build();
        return customerRepository.save(customer);
    }
    public void deleteCustomer(Long id){
         customerRepository.deleteById(id);
    }
}
