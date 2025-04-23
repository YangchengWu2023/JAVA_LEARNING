package org.example;

public class ThreadCrashTest {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("Thread " + t.getName() + " died due to: " + e.getMessage());
            System.out.println("We are restarting the service, please wait.");
        });

        Thread t = new Thread(() -> {
            throw new RuntimeException("Something exploded!");
        });

        t.start();
    }
}