package com.devsuperior.dscommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ErrorCustomizado {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
