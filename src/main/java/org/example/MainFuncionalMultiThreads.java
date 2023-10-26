package org.example;

import org.example.controller.AsyncProcessorMultithreads;

import java.util.List;
import java.util.concurrent.Future;

public class MainFuncionalMultiThreads {
    public static void main(String[] args) {
        int threadCount = 4;
        int taskCount = 6;
        AsyncProcessorMultithreads processor = new AsyncProcessorMultithreads(threadCount);

        List<Future<Void>> futures = processor.processAsyncConcurrently(taskCount,
                result -> {
                    System.out.println(result);
                },
                e -> {
                    System.err.println("Error en funcional con multihilos : " + e.getMessage());
                }
        );

        // Esperar a que todas las tareas asincrónicas terminen
        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        processor.shutdown();
    }
}

