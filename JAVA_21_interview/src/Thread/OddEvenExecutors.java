package Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OddEvenExecutors {

    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(2);

        IntStream.range(1,10).forEach(
                e->{

                    CompletableFuture<Integer> even=CompletableFuture.completedFuture(e).thenApplyAsync(x->{
                        if (x % 2 == 0) {
                            System.out.println("Thread Name even" + Thread.currentThread().getName() + " : " + x);
                        }
                        return e;
                    },service);

                    even.join();


                    CompletableFuture<Integer> odd=CompletableFuture.completedFuture(e).thenApplyAsync(x->{
                        if (x % 2 != 0) {
                            System.out.println("Thread Name odd" + Thread.currentThread().getName() + " : " + x);
                        }
                        return e;
                    },service);

                    odd.join();

                });



       // Executor executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "Async", service)
                .thenApplyAsync(data -> data + " Processing", service);
        System.out.println("Result: " + future.join());

        service.shutdown();


    }


}
