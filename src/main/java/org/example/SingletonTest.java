package org.example;

import java.util.concurrent.atomic.AtomicReference;

final class LazySingleton {

    private static class SingletonHelper {
        // The unique instance of Singleton, created when the class is accessed
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    // Private constructor prevents instantiation from other classes
    private LazySingleton() {}

    // Public method to provide access to the Singleton instance
    public static LazySingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

final class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}

public final class SingletonTest {
    private static final AtomicReference<SingletonTest> instance = new AtomicReference<>();

    String content;

    SingletonTest(String input) {
        this.content = input;
    }
    private SingletonTest() {}
    public static void main(String[] args) {
        // all should be the same since it's lazy singleton now
        System.out.println(SingletonTest.getInstance("hello").content);
        System.out.println(SingletonTest.getInstance("hello").hashCode());
        System.out.println(SingletonTest.getInstance("hi").content);
        System.out.println(SingletonTest.getInstance("hi").hashCode());
        System.out.println(SingletonTest.getInstance("yeah").content);
        System.out.println(SingletonTest.getInstance("yeah").hashCode());
    }

    public static SingletonTest getInstance(String test) {
        instance.compareAndSet(null, new SingletonTest(test));
        return instance.get();
    }
}