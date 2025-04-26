package com.isai.demo_programming_reactive.service;

import java.time.Duration;
import java.util.Random;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LearningReactiveService {
    private Random random = new Random();

    // Simula una llamada externa con una espera aleatoria (0-9 segundos) y siempre
    // retorna "Respuesta".
    public Mono<String> callExternalServiceMono() {
        Integer delay = random.nextInt(10);
        return Mono.delay(Duration.ofSeconds(delay))
                .map(response -> "Respuesta");
    }

    // Emite secuencialmente la cadena "[valor]" siete veces, con un retraso de un
    // segundo entre cada emisión.
    public Flux<String> callExternalServiceFlux() {
        return Flux.just("Hola", "Mundo", "!", "Estoy", "aprendiendo", "programacón", "reactiva")
                .delayElements(Duration.ofSeconds(1))
                .map(valor -> "[" + String.valueOf(valor) + "]");
    }

    //Emite las palabras "Hola", "Mundo", "!", "Estoy", "aprendiendo", "programación", "reactiva" con un retraso aleatorio de 0 a 2 segundos entre cada una.
    public Flux<String> callExternalServiceFluxRandon() {
        return Flux.just("Hola", "Mundo", "!", "Estoy", "aprendiendo", "programacón", "reactiva")
                .delayElements(Duration.ofSeconds(random.nextInt(3)));
    }
}
