package demo2;

import aop.Person;

import java.util.Random;

public class Operation {
    public static void main(String[] args) {
        Random random = new Random();
        boolean b = random.nextBoolean();
        double v = random.nextDouble();
        System.out.println("b:"+b+"v:"+v);
        //1
        Person person = new Person();
        Class g = person.getClass();
        //2
        Class c = Person.class;
        //3
        try {
            Class f = Class.forName("aop.Person");
            System.out.println(f==c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(g == c);

    }
}
