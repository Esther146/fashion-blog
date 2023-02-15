package com.esther.fashion_ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CustomErrorResponse {
    @JsonFormat(pattern = "yyyy-mm-dd  HH:mm:ss")
    private ZonedDateTime timestamp;
    private int statusCode;
    private String path;
    private String message;
}
