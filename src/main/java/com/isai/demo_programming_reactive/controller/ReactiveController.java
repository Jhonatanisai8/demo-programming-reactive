package com.isai.demo_programming_reactive.controller;

import org.springframework.web.bind.annotation.RestController;

import com.isai.demo_programming_reactive.service.LearningReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api/v1")
public class ReactiveController {

    @Autowired
    private final LearningReactiveService learningReactiveService;

    public ReactiveController(LearningReactiveService learningReactiveService) {
        this.learningReactiveService = learningReactiveService;
    }

    @RequestMapping(path = "/getDelayMono", method = RequestMethod.GET)
    public Mono<String> getDelayMono() {
        return learningReactiveService.callExternalServiceMono();
    }

    @GetMapping(path = "/getDelayFlux")
    public Flux<String> getDelayFlux() {
        return learningReactiveService.callExternalServiceFlux();
    }

    @GetMapping("/getDelayFluxRandon")
    public Flux<String> getDelayFluxRandon() {
        return learningReactiveService.callExternalServiceFluxRandon();
    }
    

}
