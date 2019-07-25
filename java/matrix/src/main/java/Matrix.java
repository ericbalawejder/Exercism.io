public class Matrix {

    private int[][] matrix;
    private int rows;
    private int columns;

    Matrix(String matrixAsString) {
        String[] rowCount = matrixAsString.split("\\n");
        String[] columnCount = rowCount[0].split(" ");
        rows = rowCount.length;
        columns = columnCount.length;
        matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                String[] rowAsStrings = rowCount[row].split(" ");
                matrix[row][column] = Integer.parseInt(rowAsStrings[column]);
            }
        }
    }

    int getRowsCount() {
        return rows;
    }

    int getColumnsCount() {
        return columns;
    }

    int[] getRow(int row) {
        return this.matrix[row - 1].clone();
    }

    int[] getColumn(int col) {
        int[] column = new int[rows];
        for (int row = 0; row < rows; row++) {
            column[row] = matrix[row][col - 1];
        }
        return column;
    }

    private static void print(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void print(String[] array) {
        for (String number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}
