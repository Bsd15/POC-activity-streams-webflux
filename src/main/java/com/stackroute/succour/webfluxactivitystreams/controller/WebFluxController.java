package com.stackroute.succour.webfluxactivitystreams.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;

@RestController
public class WebFluxController {
//    Set up Web Client
    WebClient webClient = WebClient
            .builder()
            .baseUrl("http://localhost:8080")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
            .build();

    @RequestMapping("/webflux-activity-streams")
    public Flux getActivityStreams(){

        return null;
    }
}
