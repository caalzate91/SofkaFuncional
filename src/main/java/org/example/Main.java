package org.example;


import org.example.controller.AsyncCallbackInterfase;
import org.example.controller.AsyncProcessor;

public class Main {
    public static void main(String[] args) {

        AsyncProcessor processor = new AsyncProcessor();

        AsyncCallbackInterfase callback = new AsyncCallbackInterfase() {
            @Override
            public void onComplete(String result) {
                System.out.println(result);
            }

            @Override
            public void onError(Exception e) {
                System.err.println("Error provocado por Camilo: " + e.getMessage());
            }
        };

        processor.processAsync(callback);

        // Esperar un momento para que el proceso asincrónico termine
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.shutdown();
    }
}
