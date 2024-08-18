package com.projetoweb_backend.projetoweb_backend_2.infrastructure.exception;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private String stacktrace;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }


    /*
    Os getters e setters foram chamados manualmente porque não foi
    possível chamar o método setStacktrace utilizando a anotação @Data.
*/

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }
}

