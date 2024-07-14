package com.cloud.department_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class MessageService {

    @Value("${spring.boot.message}")
    String message;

    public String getMessage(){
        return message;
    }
}
