package demo5;

/**
 * 构造器初始化
 */
class Window {
    Window(int maker) {
        System.out.println("Window("+maker+")");
    }
}

class House {
    Window w1 = new Window(1);

    House() {
        System.out.println("House");
        w3 = new Window(33);
    }
    House(int maker) {
        System.out.println("maker("+maker+")");
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(33);
}
public class OrderOfInitialization {
    public static void main(String[] args) {
         House h = new House();
         h.f();
         h = new House(22);

    }

}
