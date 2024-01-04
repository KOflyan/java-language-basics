package lesson5.classwork.student;

public class ITStudent extends Student {

    public ITStudent(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello world!";
    }

    public void rest() {
        System.out.println("Resting");
    }

    public static void main(String[] args) {
        ITStudent s = new ITStudent("Alice");

        System.out.println(s.sayHello());

        Student s1 = new ITStudent("Bob");

        System.out.println(s1.sayHello());
//        System.out.println(s1.rest()); // will throw an error
    }
}
