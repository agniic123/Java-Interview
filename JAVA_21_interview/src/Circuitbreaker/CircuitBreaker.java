package Circuitbreaker;

public class CircuitBreaker {
    private enum State { CLOSED, OPEN, HALF_OPEN }

    private State state = State.CLOSED;
    private int failureCount = 0;
    private int failureThreshold = 3;
    private long lastFailureTime = 0;
    private long retryTimePeriod = 5000; // 5 seconds

    public synchronized boolean allowRequest() {
        switch (state) {
            case OPEN:
                if (System.currentTimeMillis() - lastFailureTime > retryTimePeriod) {
                    state = State.HALF_OPEN;
                    return true;
                }
                return false;
            case HALF_OPEN:
            case CLOSED:
                return true;
            default:
                return false;
        }
    }

    public synchronized void recordSuccess() {
        state = State.CLOSED;
        failureCount = 0;
    }

    public synchronized void recordFailure() {
        failureCount++;
        lastFailureTime = System.currentTimeMillis();
        if (failureCount >= failureThreshold) {
            state = State.OPEN;
        }
    }
}
