package com.example.Api_rest_practica.controller;

import com.example.Api_rest_practica.model.Customer;
import com.example.Api_rest_practica.model.dto.CustomerDto;
import com.example.Api_rest_practica.responses.ApiResponse;
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
    public ResponseEntity<?> getAllCustomer() {
        try {
            List<Customer> customer = customerService.getALLCustomer();
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(200)
                    .error(false)
                    .message("Lista de Customer")
                    .data(customer)
                    .build()
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(500)
                    .error(true)
                    .message("Error: " + e.getMessage())
                    .data(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Customer customer = customerService.findById(id);
            if (customer == null) {
                return new ResponseEntity<>(ApiResponse.builder()
                        .status(404)
                        .error(true)
                        .message("No se ha encontrado el customer")
                        .data(null)
                        .build()
                        , HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(200)
                    .error(false)
                    .message("Customer encontrado")
                    .data(
                            CustomerDto.builder().
                                    id(customer.getId())
                                    .phone(customer.getPhone())
                                    .documentNumber(customer.getDocumentNumber())
                                    .documentType(customer.getDocumentType())
                                    .name(customer.getName())
                                    .build()
                    )
                    .build()
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(500)
                    .error(true)
                    .message("Error: " + e.getMessage())
                    .data(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customer) {
        try {
            Customer customerSave = customerService.saveCustomer(customer);
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(201)
                    .error(false)
                    .message("Customer creado")
                    .data(
                            CustomerDto.builder().
                                    id(customerSave.getId())
                                    .phone(customerSave.getPhone())
                                    .documentNumber(customerSave.getDocumentNumber())
                                    .documentType(customerSave.getDocumentType())
                                    .name(customerSave.getName())
                                    .build()
                    )
                    .build()
                    , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(500)
                    .error(true)
                    .message("Error: " + e.getMessage())
                    .data(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customer) {
        try {
            Customer customerUpdate = customerService.saveCustomer(customer);
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(200)
                    .error(false)
                    .message("Customer Actualizado")
                    .data(
                            CustomerDto.builder().
                                    id(customerUpdate.getId())
                                    .phone(customerUpdate.getPhone())
                                    .documentNumber(customerUpdate.getDocumentNumber())
                                    .documentType(customerUpdate.getDocumentType())
                                    .name(customerUpdate.getName())
                                    .build()
                    )
                    .build()
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(500)
                    .error(true)
                    .message("Error: " + e.getMessage())
                    .data(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            Customer customer=customerService.findById(id);
            if (customer == null) {
                return new ResponseEntity<>(ApiResponse.builder()
                        .status(404)
                        .error(true)
                        .message("No se ha encontrado el customer")
                        .data(null)
                        .build()
                        , HttpStatus.NOT_FOUND);
            }
            customerService.deleteCustomer(customer);
            return new ResponseEntity<>(
                    ApiResponse
                            .builder()
                            .status(200)
                            .data(null)
                            .message("Eliminado correctamente")
                            .error(false)
                            .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.builder()
                    .status(500)
                    .error(true)
                    .message("Error: " + e.getMessage())
                    .data(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
