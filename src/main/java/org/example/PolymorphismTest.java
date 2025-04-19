package org.example;

/*



 */

class A {
    public void show() {
        System.out.println("A's show");
    }

    public void triggerShow() {
        show(); // This will call the overridden method if the object is of subclass B
    }
}

class PolymorphismTest extends A {
    @Override
    public void show() {
        System.out.println("B's show");
    }

    public static void main(String[] args) {
        PolymorphismTest b = new PolymorphismTest();
        b.triggerShow(); // Output: "B's show"
        A a = new A();
        a.triggerShow();
    }
}