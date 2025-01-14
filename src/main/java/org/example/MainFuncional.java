package org.example;

import org.example.controller.AsyncProcessorFunctional;

public class MainFuncional {
    public static void main(String[] args) {
        AsyncProcessorFunctional processor = new AsyncProcessorFunctional();

        processor.processAsync()
                .subscribe(
                        result -> System.out.println("Resultado: " + result),
                        e -> System.err.println("Error pero en funcional: " + e.getMessage())
                );

        // Esperar un momento para que el proceso asincrónico termine
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
