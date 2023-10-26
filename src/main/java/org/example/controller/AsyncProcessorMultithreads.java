package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Consumer;

public class AsyncProcessorMultithreads  {
    private ExecutorService executorService;

    public AsyncProcessorMultithreads(int threadCount) {
        executorService = Executors.newFixedThreadPool(threadCount);
    }

    public List<Future<Void>> processAsyncConcurrently(int taskCount, Consumer<String> onComplete, Consumer<Exception> onError) {
        List<Future<Void>> futures = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            futures.add(executorService.submit(() -> {
                try {
                    // Simular un proceso asincrónico
                    Thread.sleep(2000);

                    // Simular que el proceso ha completado
                    String result = "Proceso completado exitosamente.";
                    onComplete.accept(result);
                } catch (Exception e) {
                    onError.accept(e);
                }
                return null; // El resultado de onComplete es Void
            }));
        }
        return futures;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}