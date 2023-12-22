package lesson4.classwork;

public class Student {
    private String name;
    private String university;
    private boolean isLazy;

    public Student(
            String name,
            String university,
            boolean isLazy
    ) {
        this.name = name;
        this.university = university;
        this.isLazy = isLazy;
    }

    public Student(String name, String university) {
        this.name = name;
        this.university = university;
        this.isLazy = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    public void doHomework() {
        if (this.isLazy) {
            System.out.println("Homework? I have TV shows to watch.");
        } else {
            System.out.println("Homework is done.");
        }
    }

    public void switchUniversity(String university) {
        System.out.printf("%s leaves %s and starts studying in %s\n", this.name, this.university, university);
        this.university = university;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.name, this.university);
    }

    public static void main(String[] args) {
        Student mary = new Student("Mary", "Tartu University");
        Student alice = new Student("Alice", "Taltech", true);

        alice.doHomework();
        mary.doHomework();

        alice.switchUniversity("Tartu Unversity");
        alice.setLazy(false);

        alice.doHomework();
    }
}
