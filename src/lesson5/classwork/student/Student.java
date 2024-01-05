package lesson5.classwork.student;

public abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract String sayHello();

    public void doHomework() {
        System.out.println("Homework is done!");
    }
}
