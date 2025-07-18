package Circuitbreaker;

public class ExternalService {
    public static String call() throws Exception {
        // Simulating failure
        double random = Math.random();
        if (random < 0.7) {
            throw new Exception("Service failure:::::"+random);
        }
        return "Service response:::"+random;
    }
}

