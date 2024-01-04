package lesson2.homework.EX02C;

public class EX02C {

    public static int getCellIndex(int rowIndex, int colIndex, int rowLength) {
        if (colIndex > rowLength) return -1;
        return rowLength*rowIndex + colIndex;
    }

    public static int getRowIndex(int cellIndex, int rowLength) {
        return cellIndex /rowLength;
    }

    public static int getColIndex(int cellIndex, int rowLength) {
        return cellIndex %rowLength;
    }

    public static int getRowLength(int rowIndex, int colIndex, int cellIndex) {
        if (rowIndex == 0) return -1;

        for (int len = cellIndex/rowIndex-1;;len++) {
            int index = getCellIndex(rowIndex, colIndex, len);
            if (cellIndex < index) return -1;
            if (cellIndex == index) return len;
        }
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
