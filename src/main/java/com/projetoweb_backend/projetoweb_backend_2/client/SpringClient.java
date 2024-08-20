package com.projetoweb_backend.projetoweb_backend_2.client;

import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Log4j
public class SpringClient {

  private static final Logger log = LogManager.getLogger(SpringClient.class);

  public static void main(String[] args){
    WebClient webClient =   WebClient.builder()
            .baseUrl("http://localhost:8080/usuarios/")
            .defaultHeader(HttpHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE).build();

    String response = webClient.get()
            .uri("/findeall")
            .retrieve().bodyToMono(String.class).block();

    log.info(response);

  }
}
