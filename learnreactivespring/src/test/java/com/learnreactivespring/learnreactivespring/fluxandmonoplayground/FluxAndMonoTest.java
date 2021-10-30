package com.learnreactivespring.learnreactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {
    @Test
    public void fluxTest() {
        Flux<String> flux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
/*
               .concatWith(Flux.error(new RuntimeException("Error")))
*/
                .concatWith(Flux.just("After error"))
                .log();
        flux
                .subscribe(System.out::println,
                        (e) -> System.err.println("exception is " + e)
                        , () -> System.out.println("Completed"));
    }

    @Test
    public void fluxTestElements_WithoutError() {
        Flux<String> flux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .log();
        StepVerifier.create(flux)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                .verifyComplete();
    }

    @Test
    public void fluxTestElements_WithError() {
        Flux<String> flux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Error")))
                .log();
        StepVerifier.create(flux)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                .expectError(RuntimeException.class)
                .verify();
    }


    @Test
    public void fluxTestElementsCount_WithError() {
        Flux<String> flux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Error")))
                .log();
        StepVerifier.create(flux)
                .expectNextCount(3)
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    public void monoTest(){
    Mono <String> stringMono = Mono.just("Spring");
    StepVerifier.create(stringMono.log())
            .expectNext("Spring")
            .verifyComplete();
    }

    @Test
    public void monoTestError(){
        Mono <String> stringMono = Mono.error(new RuntimeException("hello exception"));
        StepVerifier.create(stringMono.log())
                .expectError(RuntimeException.class)
                .verify();
    }
}