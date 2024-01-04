package lesson2.homework.EX02C;

public class EX02C {

    static int getCellIndex(int rowIndex, int colIndex, int rowLength) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        if (colIndex > rowLength - 1) {
            return -1;
        }

        return rowIndex * rowLength + colIndex;
        //////////////////////////////////////////////////////////////////////
    }

    static int getRowIndex(int cellIndex, int rowLength) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        return cellIndex / rowLength;
        //////////////////////////////////////////////////////////////////////
    }

    static int getColIndex(int cellIndex, int rowLength) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        return cellIndex % rowLength;
        //////////////////////////////////////////////////////////////////////
    }

    static int getRowLength(int rowIndex, int colIndex, int cellIndex) {
        // Your code here
        //////////////////////////////////////////////////////////////////////
        if (rowIndex == 0) {
            return -1;
        }

        double result = (double) (cellIndex - colIndex) / rowIndex;


        if (result <= colIndex || result != (int) (result)) {
            return -1;
        }

        return (int) result;
        //////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        System.out.println(EX02C.getCellIndex(0, 0, 10)); // --> 0
        System.out.println(EX02C.getCellIndex(5, 5, 10)); // --> 55

        System.out.println(EX02C.getRowIndex(55, 10)); // --> 5
        System.out.println(EX02C.getColIndex(55, 10)); // --> 5
        System.out.println(EX02C.getRowIndex(12, 3)); // --> 4
        System.out.println(EX02C.getColIndex(12, 3)); // --> 0

        System.out.println(EX02C.getRowLength(5, 5, 55)); // --> 10

        System.out.println(EX02C.getRowLength(1, 1, 12)); // --> 11
    }
}
