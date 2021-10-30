package com.learnreactivespring.learnreactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxAndMonoFactoryTest {
    List <String> names = Arrays.asList("Ana", "Jak", "Jeny");

    @Test
    public void fluxUsingIterable(){
      Flux<String> namesFlux = Flux.fromIterable(names).log();
        StepVerifier.create(namesFlux)
                .expectNext("Ana", "Jak", "Jeny")
                .verifyComplete();
    }

    @Test
    public void fluxUsingArray(){
        String [] names = new String[]{"Adam", "Ana", "Jak", "Jeny"};
       Flux<String> namesFlux =  Flux.fromArray(names);
        StepVerifier.create(namesFlux)
                .expectNext("Adam", "Ana", "Jak", "Jeny")
                .verifyComplete();

    }

    @Test
    public void fluxUsingStream(){
        Flux<String> namesFlux = Flux.fromStream(names.stream());
        StepVerifier.create(namesFlux)
                .expectNext("Ana", "Jak", "Jeny")
                .verifyComplete();

    }

    @Test
    public void monoWithJustOrEmpty(){
        Mono <String> monoString = Mono.justOrEmpty(null);
        StepVerifier.create(monoString.log())
                .verifyComplete();
    }

    @Test
    public void monoUsingSupplier(){
        //implementam interfata supplier
        Supplier<String> stringSupplier = () -> "mono";

        Mono <String> stringMono = Mono.fromSupplier(stringSupplier);
        System.out.println (stringSupplier.get());
        StepVerifier.create(stringMono.log())
                .expectNext( "mono")
                .verifyComplete();
    }


    @Test
    public void fluxUsingRange(){
        Flux<Integer> integerFlux = Flux.range(1,6);
        StepVerifier.create(integerFlux)
                .expectNext(1,2,3,4,5,6)
                .verifyComplete();
    }
}
