package org.example;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
enum Priority { LOW, MEDIUM, HIGH }
@Retention(RetentionPolicy.RUNTIME)  // ← Critical for runtime access
public @interface Author {
    String name();
    String date();
    String location() default "abcd";
    Priority dob() default Priority.MEDIUM;
}
