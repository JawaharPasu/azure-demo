package com.jawa.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private List<String> message;
    private String description;
}
