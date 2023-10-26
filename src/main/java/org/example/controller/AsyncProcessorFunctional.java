package org.example.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

public class AsyncProcessorFunctional {
    private ExecutorService executorService;

    public AsyncProcessorFunctional() {
        executorService = Executors.newSingleThreadExecutor();
    }

    public void processAsync(Consumer<String> onComplete, Consumer<Exception> onError) {
        executorService.submit(() -> {
            try {
                // Simular un proceso asincrónico
                Thread.sleep(2000);

                // Simular error en el proceso
                //int valNumber = Integer.parseInt("Hola");
                // Simular que el proceso ha completado
                String result = "Proceso completado exitosamente.";
                onComplete.accept(result);
            } catch (Exception e) {
                onError.accept(e);
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
