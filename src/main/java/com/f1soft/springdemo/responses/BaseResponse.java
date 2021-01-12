package com.f1soft.springdemo.responses;

import lombok.Data;

@Data
public class BaseResponse extends Response {
    private Object data;



    public BaseResponse(Integer code, Boolean success, String message, Object data) {
        super(code, success, message);
        this.data = data;
    }

    public BaseResponse(Integer code, Boolean success, String message) {
        super(code, success, message);
        this.data = data;

    }
}
