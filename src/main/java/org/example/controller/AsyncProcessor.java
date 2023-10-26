package org.example.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncProcessor {
    private ExecutorService executorService;

    public AsyncProcessor() {
        executorService = Executors.newSingleThreadExecutor();
    }

    public void processAsync(AsyncCallbackInterfase callback) {
        executorService.submit(() -> {
            try {
                // Simular un proceso asincrónico
                Thread.sleep(2000);

                // Simular que el proceso ha completado
                int valNumber = Integer.parseInt("Hola");
                String result = "Proceso completado exitosamente.";
                callback.onComplete(result);
            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
