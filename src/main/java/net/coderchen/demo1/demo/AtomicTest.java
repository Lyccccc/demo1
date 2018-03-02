package net.coderchen.demo1.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Liuyuchen on 2018/02/28.
 */
public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        Person person1 = new Person("liuyuchen",25);
        AtomicReference<Person> personAtomicReference = new AtomicReference<Person>(person1);
        Person person2 = new Person("liuyuchen",26);
        System.out.println(personAtomicReference.compareAndSet(person1, person2));
        System.out.println(personAtomicReference.get());
    }

    static class Person{
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
