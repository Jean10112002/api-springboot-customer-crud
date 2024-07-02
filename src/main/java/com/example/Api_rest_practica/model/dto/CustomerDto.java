package com.example.Api_rest_practica.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Builder
@ToString
@Data
public class CustomerDto implements Serializable {
    private Long id;
    private String documentType,documentNumber,name,phone;
}
