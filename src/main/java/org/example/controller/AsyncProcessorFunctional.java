package org.example.controller;

import reactor.core.publisher.Mono;
import java.time.Duration;

public class AsyncProcessorFunctional {
    public Mono<String> processAsync() {
        return Mono.fromCallable(() -> {
                    // Simular un proceso asincrónico
                    Thread.sleep(2000);
                    // Simular que el proceso ha completado
                    return "Proceso completado exitosamente.";
                }).delayElement(Duration.ofSeconds(2))
                .onErrorResume(e -> Mono.error(new RuntimeException("Error en el proceso", e)));
    }
}