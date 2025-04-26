package com.isai.demo_programming_reactive.reactive;

import java.time.Duration;
import java.util.Optional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactivePractice {
    public static void main(String[] args) throws InterruptedException {
        //monoOne();
        //exampleFlux();
        //exampleFluxConTime();
        //damos un tiempo de 10 segundos al metodo para que termine de emitir valores
        //Thread.sleep(Duration.ofSeconds(10));
        exampleMonoEmpty();
    }

    public static void monoOne() {

        //Mono es un tipo de flujo que elimite 0 o 1 elemento
        //creación del mono:
        Mono<String> mono = Mono.just("Hola Mundo!, Estoy aprendiendo programación reactiva....");

        //suscripcion al mono
        mono.subscribe(
                valor -> System.out.println("Recibiendo: ".concat(valor)),
                error -> System.out.println("Error: ".concat(error.getMessage())),
                () -> System.out.println("Terminado...."));
    }

    public static void exampleFlux(){
        //Flux es un tipo de flujo que elimite 0,1 o n elementps
        //creamos el flux 
        //va a emitir varios valores uno tras otro
        Flux<String> fluxStrings = Flux.just("Hola","Mundo","!","Estoy","aprendiendo","programacón","reactiva");

        //se suscriben al flux 
        //se define que se hara cada vez que se recibe un valor
        fluxStrings.subscribe(
            valor  -> System.out.println("Recibiendo: ".concat(valor)),
            error  -> System.out.println("Error: ".concat(error.getMessage())),
            () -> System.out.println("Terminado...")
        );
    }

    public static void exampleFluxConTime(){
        //creamos el flux 
        //va a emitir varios valores uno tras otro
        //se demorara 1 segundo en recibir el siguiente
        Flux<String> fluxStrings = Flux.just("Hola","Mundo","!","Estoy","aprendiendo","programacón","reactiva")
        .delayElements(Duration.ofSeconds(1));

        //se suscriben al flux 
        //se define que se hara cada vez que se recibe un valor
        fluxStrings.subscribe(
            valor  -> System.out.println("Recibiendo: ".concat(valor).concat(logThread())),
            error  -> System.out.println("Error: ".concat(error.getMessage())),
            () -> System.out.println("Terminado...")
        );
    }

    public static void exampleMonoEmpty(){
        //es un Mono que no devuelve ningun valor osea void
        //si hay un valor se emite y si no no emite nada
        Mono<Void> monoEmpty = Mono.justOrEmpty(Optional.empty());
        //se ejecutaria si habria algun valor
        monoEmpty.subscribe(
            valor  -> System.out.println("Recicibiendo: ".concat(valor.toString())),
            error  -> System.out.println("Error: ".concat(error.getMessage())),
            () -> System.out.println("Terminado...")
        );
    }

    private static String logThread() {
        return " [ ".concat(Thread.currentThread().getName()).concat(" ]");
    }

}
