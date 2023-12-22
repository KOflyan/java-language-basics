package lesson4.classwork;

public class Overload {

    private static String methodOverloadTest = "This is method overload test!";
    private String methodOverloadTestInstance = "This is method overload test! (instance)";

    public void doStuff() {
        System.out.println("Doing stuff");
    }

    public String doStuff(String stuff) {
        return String.format("Stuff to do: %s", stuff);
    }

    public int doStuff(int amountOfStuff) {
        return amountOfStuff * 10;
    }

    public static void main(String[] args) {
        Overload overload = new Overload();

        System.out.println(overload.doStuff("Buy groceries"));
        System.out.println(overload.doStuff(8));

        overload.doStuff();


        System.out.println(Overload.methodOverloadTest);
        System.out.println(overload.methodOverloadTestInstance);


    }
}
