package lesson2.classwork;

class Test {
    public static void main(String[] args) {
        System.out.println(xyzThere("abc.xyzxyz"));
    }

    public static boolean xyzThere(String str) {
        if (str.substring(0, Math.min(3, str.length())).equals("xyz")) return true;
        return str.matches("^xyz|[^\\.]xyz");
    }

}
