package aop;

public class Person {
    public void run() {
        System.out.println("我在run");
    }
    public void run(int i) {
        System.out.println("我在run"+i);
    }

    public void song() {
        System.out.println("我在sing");
    }

}
