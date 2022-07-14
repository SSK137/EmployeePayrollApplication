package com.example.employeepayrollapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponceDTO {
    String message;
    Object data;

    public ResponceDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponceDTO() {
    }
}
