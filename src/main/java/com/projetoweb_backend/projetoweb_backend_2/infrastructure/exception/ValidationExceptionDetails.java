package com.projetoweb_backend.projetoweb_backend_2.infrastructure.exception;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ValidationExceptionDetails {
    private LocalDateTime timestamp;
    private int status;
    private String title;
    private String details;
    private String developerMessage;
    private String fields;
    private String fieldsMessage;

}

