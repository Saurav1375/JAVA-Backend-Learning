package org.example;

public class Student {

    private Computer computer;
    private int age;

//    public Student(int age) {
//        this.age = age;
//    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void greetStudent() {
        computer.compile();
        System.out.println("Hello Student");
    }
}
