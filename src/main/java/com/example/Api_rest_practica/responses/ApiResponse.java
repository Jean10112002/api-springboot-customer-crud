package com.example.Api_rest_practica.responses;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Data
@ToString
public class ApiResponse<M> implements Serializable {
    private int status;
    private String message;
    private boolean error;
    private Object data;
}
