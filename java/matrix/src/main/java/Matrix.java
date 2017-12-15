// Given a string representing a matrix of numbers, return the rows and columns of
// that matrix.
public class Matrix
{
    public static void main(String[] args)
    {
        String testMatrix = "3 4 6\n" +
                            "5 9 8\n" +
                            "2 4 0";
        
        System.out.println(testMatrix);
        Matrix matrix = new Matrix(testMatrix);
        System.out.println(matrix.getRowsCount());
        System.out.println(matrix.getColumnsCount());
        print(matrix.getColumn(2));
        print(matrix.getRow(0));
    }
    
    private int[][] matrix;
    private int rows;
    private int columns;

    Matrix(String matrixAsString)
    {
        createMatrix(matrixAsString);
    }

    private void createMatrix(String matrixAsString)
    {
        String[] rowsAsStrings = matrixAsString.split("\\n");
        String[] numbersInColumnAsStrings = rowsAsStrings[0].split(" ");

        rows = rowsAsStrings.length;
        columns = numbersInColumnAsStrings.length;

        matrix = new int[rows][columns];
        fillMatrix(rowsAsStrings);
    }

    private void fillMatrix(String[] stringRows)
    {
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                String[] rowAsStrings = stringRows[row].split(" ");
                matrix[row][col] = Integer.valueOf(rowAsStrings[col]);
            }
        }
    }

    int getRowsCount()
    {
        return rows;
    }

    int getColumnsCount()
    {
        return columns;
    }

    int[] getRow(int row)
    {
        return matrix[row];
    }

    int[] getColumn(int col)
    {
        int[] column = new int[rows];
        for (int row = 0; row < rows; row++)
        {
            column[row] = matrix[row][col];
        }
        return column;
    }
    
    static void print(int[] array)
    {
        for (int number : array)
        {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
