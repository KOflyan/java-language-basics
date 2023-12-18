package lesson3.classwork;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseThree {
    public static void main(String[] args) {
        Map<String, Double> studentGrades = new HashMap<>();

        studentGrades.put("Mary", 4.5);
        studentGrades.put("Sander", 3.7);
        studentGrades.put("Kirill", 3.4);
        studentGrades.put("Alice", 2.3);

        System.out.println(studentGrades.size());
        System.out.println(studentGrades);

//        studentGrades.remove("Mary");

        System.out.println(studentGrades);


        System.out.println(studentGrades.get("Sander"));

        List<String> topPerformingStudents = new ArrayList<>();

        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            if (entry.getValue() >= 4) {
                topPerformingStudents.add(entry.getKey());
            }
        }

        System.out.println(topPerformingStudents);
    }
}
