package com.stackroute.succour.webfluxactivitystreams.controller;

import com.ibm.common.activitystreams.Activity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;

import static com.ibm.common.activitystreams.Makers.activity;
import static com.ibm.common.activitystreams.Makers.object;

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
    public Flux<Activity> getActivityStreams(){
        Activity activity =
                activity()
                        .actor(object("person").id("acct:joe@example.org"))
                        .object(object("note").content("my note"))
                        .verb("post")
                        .get();
        return Flux.just(activity);
    }
}
