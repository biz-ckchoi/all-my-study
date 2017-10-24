package chapter1.sector04;


public class SuperTest {

    public static void main(String[] args) {
        class Greeter {
            public void greet() {
                System.out.println("Hello, World!");
            }
        }

        class ConcurrentGreeter extends Greeter {
            public void greet() {
                Thread t = new Thread(super::greet);
                t.start();
            }
        }

        new ConcurrentGreeter().greet();
    }

}
