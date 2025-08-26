package br.com.tulioemmanuel.btgtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FileProcessorCorrect implements CommandLineRunner {
    
    private static List<String> lines = new ArrayList<>();
    private static Integer NUM_THREADS = 1; // Número de Threads

    @Override
    public void run(String... args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS ; i++) { // Starta tasks somente para o número de threads
            executor.submit(() -> {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("data.txt"));
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line.toUpperCase());
                    }
                    br.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

        // Aguarda até as threads finalizarem
        while (!executor.awaitTermination(100, TimeUnit.MILLISECONDS)) {}

        System.out.println("Lines processed: " + lines.size());
    }
}