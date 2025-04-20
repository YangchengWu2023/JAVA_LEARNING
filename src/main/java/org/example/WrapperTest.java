package org.example;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class WrapperTest<T> {
    Consumer<String> print = System.out::println;
    private Wrapper<T> value;
    private class Wrapper<T> {
        T value;
        private Wrapper(T value) { this.value = value; }
    }
    public void set(T val) {
        this.value = new Wrapper<>(val);
    }
    public void checkState() {
        if (this.value == null) {
            print.accept("UNSET");
        }
        else if (this.value.value == null) {
            print.accept("SET TO BE NULL");
        }
        else {
            print.accept("SET TO BE OTHERS");
        }
    }
    public static void main(String[] args) {
        WrapperTest<String> demo = new WrapperTest<>();

        // Case 1: Unset state
        demo.checkState(); // [UNSET]

        // Case 2: Set to null
        demo.set(null);
        demo.checkState(); // [SET TO NULL]

        // Case 3: Set to actual value
        demo.set("Hello");
        demo.checkState(); // [SET] Value = Hello

        // Case 4: Reset to null
        demo.set(null);
        demo.checkState(); // [SET TO NULL] (not unset!)
    }
}