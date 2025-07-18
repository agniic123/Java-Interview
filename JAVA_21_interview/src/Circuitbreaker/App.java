package Circuitbreaker;

public class App {
    public static void main(String[] args) {
        CircuitBreaker cb = new CircuitBreaker();

        for (int i = 0; i < 10; i++) {
            if (cb.allowRequest()) {
                try {
                    String response = ExternalService.call();
                    System.out.println("Success: " + response);
                    cb.recordSuccess();
                } catch (Exception e) {
                    System.out.println("Failure: " + e.getMessage());
                    cb.recordFailure();
                }
            } else {
                System.out.println("Request blocked by circuit breaker.");
            }

            try {
                Thread.sleep(1000); // 1 sec between requests
            } catch (InterruptedException ignored) {
            }
        }
    }
}
