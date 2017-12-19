// Given a string representing a matrix of numbers, return the rows and columns of
// that matrix.
import java.util.Arrays;

public class Matrix
{
    public static void main(String[] args)
    {
        String testMatrix = "3 4 6\n" +
                            "5 9 8\n" +
                            "2 4 0";
        
        System.out.println(testMatrix);
        Matrix dmatrix = new Matrix(testMatrix);
        System.out.println(Arrays.deepToString(matrix));
        //System.out.println(matrix.getRowsCount());
        //System.out.println(matrix.getColumnsCount());
        //print(matrix.getColumn(2));
        //print(matrix.getRow(0));
    }
    
    private static int[][] matrix;
    private int rows;
    private int columns;

    Matrix(String matrixAsString)
    {
        String[] rowCount = matrixAsString.split("\\n");
        String[] columnCount = rowCount[0].split(" ");
        rows = rowCount.length;
        columns = columnCount.length;
        matrix = new int[rows][columns];
        
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                String[] rowAsStrings = rowCount[row].split(" ");
                matrix[row][col] = Integer.parseInt(rowAsStrings[col]);
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
    
    static void print(String[] array)
    {
        for (String number : array)
        {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
