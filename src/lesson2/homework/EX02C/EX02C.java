package lesson2.homework.EX02C;

public class EX02C {

    public static int getCellIndex(int rowIndex, int colIndex, int rowLength) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        return -1;
        //////////////////////////////////////////////////////////////////////
    }

    public static int getRowIndex(int cellIndex, int rowLength) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        return -1;
        //////////////////////////////////////////////////////////////////////
    }

    public static int getColIndex(int cellIndex, int rowLength) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        return -1;
        //////////////////////////////////////////////////////////////////////
    }

    public static int getRowLength(int rowIndex, int colIndex, int cellIndex) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        return -1;
        //////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        System.out.println(getCellIndex(0, 0, 10)); // --> 0
        System.out.println(getCellIndex(5, 5, 10)); // --> 55

        System.out.println(getRowIndex(55, 10)); // --> 5
        System.out.println(getColIndex(55, 10)); // --> 5
        System.out.println(getRowIndex(12, 3)); // --> 4
        System.out.println(getColIndex(12, 3)); // --> 0

        System.out.println(getRowLength(5, 5, 55)); // --> 10

        System.out.println(getRowLength(1, 1, 12)); // --> 11
    }
}
