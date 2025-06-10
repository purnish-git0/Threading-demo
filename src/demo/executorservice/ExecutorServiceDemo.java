package demo.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        try {
            startOps();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void startOps() throws Exception {

        Callable<String> callable1 = () -> {
            return "Hello";
        };

        Callable<String> callable2 = () -> {
            return " world";
        };


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> firstFuture = executorService.submit(callable1);

        Future<String> secondFuture = executorService.submit(callable2);

        System.out.println(firstFuture.get() + secondFuture.get());

    }


}


