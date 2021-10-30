package com.learnreactivespring.learnreactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxAndMonoFilterTest {
    List<String> names = Arrays.asList("Ana", "Jak", "Jeny");

    @Test
    public void filterTest(){
      Flux<String> namesFlux =   Flux.fromIterable(names).log()
      .filter(name -> name.startsWith("A"))
              .log();
        StepVerifier.create(namesFlux)
                .expectNext("Ana")
                .verifyComplete();
    }

}
