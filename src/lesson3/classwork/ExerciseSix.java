package lesson3.classwork;

import java.util.HashMap;
import java.util.Map;

public class ExerciseSix {
    public static Map<String, String> topping2(
            Map<String, String> toppings
    ) {
        if (toppings.containsKey("ice cream")) {
            String iceCreamTopping = toppings.get("ice cream");

            toppings.put("yogurt", iceCreamTopping);
        }

        if (toppings.containsKey("spinach")) {
            toppings.put("spinach", "nuts");
        }

        return toppings;
    }

    public static Map<String, Integer> wordCount(String[] array) {
        Map<String, Integer> map = new HashMap<>();

        for (String element : array) {
            int timesSeen = map.getOrDefault(element, 0);

            map.put(element, timesSeen + 1);
        }

        return map;
    }

    public static Map<String, String> mapAB3(
            Map<String, String> map
    ) {
        if (map == null) {
            return null;
        }

        if (map.containsKey("a") && map.containsKey("b")) {
            return map;
        }

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
        } else if (map.containsKey("b")) {
            map.put("a", map.get("b"));
        }

        return map;
    }


    public static void main(String[] args) {


        System.out.println(
                mapAB3(
                        new HashMap<>(){{
                            put("a", "aaa");
                            put("c", "cake");
                        }}
                )
        );

        System.out.println(
                mapAB3(
                        new HashMap<>(){{
                            put("a", "aaa");
                            put("b", "bbb");
                        }}
                )
        );
//
//        System.out.println(
//                wordCount(
//                        new String[]{
//                                "a", "b", "a", "c", "b"
//                        }
//                )
//        );

//        System.out.println(
//                topping2(
//                        new HashMap<>(){{
//                            put("ice cream", "cherry");
//                        }}
//                )
//        );
//
//        System.out.println(
//                topping2(
//                        new HashMap<>(){{
//                            put("spinach", "dirt");
//                            put("ice cream", "cherry");
//                        }}
//                )
//        );

    }
}
