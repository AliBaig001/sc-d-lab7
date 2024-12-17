package lab7;

class CalculatorThread extends Thread {
    private volatile boolean running = true; // Flag for stopping the thread safely

    public void run() {
        System.out.println("Calculator Thread started.");
        try {
            for (int i = 1; i <= 5; i++) {
                if (!running) {
                    System.out.println("Calculator Thread stopping...");
                    break;
                }
                System.out.println("Calculating: " + (i * i));
                Thread.sleep(1000); // Simulate calculation delay
            }
        } catch (InterruptedException e) {
            System.out.println("Calculator Thread interrupted.");
        }
        System.out.println("Calculator Thread completed.");
    }

    public void stopThread() {
        running = false; // Stop the thread safely
    }
}

class LoggerThread extends Thread {
    private volatile boolean running = true; // Flag for stopping the thread safely

    public void run() {
        System.out.println("Logger Thread started.");
        try {
            for (int i = 1; i <= 5; i++) {
                if (!running) {
                    System.out.println("Logger Thread stopping...");
                    break;
                }
                System.out.println("Logging Data: Entry " + i);
                Thread.sleep(1500); // Simulate logging delay
            }
        } catch (InterruptedException e) {
            System.out.println("Logger Thread interrupted.");
        }
        System.out.println("Logger Thread completed.");
    }

    public void stopThread() {
        running = false; // Stop the thread safely
    }
}

public class Task4Multithreading {
    public static void main(String[] args) {
        System.out.println("Main Thread started.");

        // Create thread objects
        CalculatorThread calculatorThread = new CalculatorThread();
        LoggerThread loggerThread = new LoggerThread();

        // Start threads
        calculatorThread.start();
        loggerThread.start();

        try {
            // Ensure CalculatorThread completes first
            calculatorThread.join();
            System.out.println("CalculatorThread has completed. LoggerThread continues...");

            // Allow LoggerThread to complete
            loggerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted.");
        }

        System.out.println("Main Thread completed.");
    }
}
