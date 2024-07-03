package com.example.Api_rest_practica.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Builder
@ToString
@Data
public class CustomerUpdateDto implements Serializable {
    @NotNull(message = "Id is mandatory")
    private Long id;
    @NotBlank(message = "Document type is mandatory")
    @Size(max = 10, message = "Document type must be less than 10 characters")
    private String documentType;
    @NotBlank(message = "Document number is mandatory")
    @Size(max = 20, message = "Document number must be less than 20 characters")
    private String documentNumber;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;
}
