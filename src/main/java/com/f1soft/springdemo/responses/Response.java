package com.f1soft.springdemo.responses;


import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private Integer code;
    private Boolean success;
    private String message;

    public Response() {}

    public Response(Integer code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
