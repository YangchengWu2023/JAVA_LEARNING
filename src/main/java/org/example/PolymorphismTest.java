package org.example;

/*
This example is to illustrate the question in (Note that this is the old v8.1.2 version, the main function has changed recently):
    https://github.com/elastic/elasticsearch/blob/31df9689e80bad366ac20176aa7f2371ea5eb4c1/server/src/main/java/org/elasticsearch/bootstrap/Elasticsearch.java#L61

Command (mainWithoutErrorHandling, main, execute(a, b)) -> EnvironmentAwareCommand(execute(a, b)) -> ElasticSearch (main, execute(a, b, c))

ElasticSearch.main => Command.main => Command.mainWithoutErrorHandling => Command.execute
Now the issue is, whose "execute" function will be really executed when it's triggered by superclass's function?
The answer is the **actual runtime type** of the object. Therefore, the result should be:
    ..... => Command.execute(a, b) = = = = > EnvironmentAwareCommand.execute(a, b)

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