package ITITWE23014_LTDANH_LAB3.Problem_IV;

import java.util.Stack;

class Person {
    String name;
    Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age + " yrs old";
    }
}

class ReverseApp {
    public static void reversePersonsList(Stack<Person> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Person person = stack.pop();
        reversePersonsList(stack);
        insertAtBottom(stack, person);
    }

    private static void insertAtBottom(Stack<Person> stack, Person person) {
        if (stack.isEmpty()) {
            stack.push(person);
        } else {
            Person top = stack.pop();
            insertAtBottom(stack, person);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Person> persons = new Stack<>();
        persons.push(new Person("John", 20));
        persons.push(new Person("Alice", 30));
        persons.push(new Person("Bob", 42));
        System.out.println("Original Stack:");
        for (Person person : persons) {
            System.out.println(person);
        }
        reversePersonsList(persons);
        System.out.println("\nReversed Stack:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}