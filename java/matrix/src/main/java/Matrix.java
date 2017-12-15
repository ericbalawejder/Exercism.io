// Given a string representing a matrix of numbers, return the rows and columns of
// that matrix.
public class Matrix
{
    public static void main(String[] args)
    {
        String testMatrix = "9 8 7\n" +
                            "5 3 2\n" +
                            "6 6 7";
        System.out.println(testMatrix);
        System.out.println(testMatrix.length());
        System.out.println(testMatrix.contains("\n"));
        
        Matrix matrix = new Matrix(testMatrix);
        System.out.println(matrix.getRowsCount());
        System.out.println(matrix.getColumnsCount());
        print(matrix.getRow(2));
    }
    
    private int[] matrix;
    private int numRows = 0;
    private int numColumns;

    Matrix(String matrixAsString)
    {
        int numberOfElements = 0;
        int val = 0;
        matrix = new int[matrixAsString.length()];
        
        for (int i = 0; i < matrixAsString.length(); i++)
        {
            if (matrixAsString.charAt(i) == '\n' || matrixAsString.charAt(i) == ' ')
            {
                matrix[numberOfElements++] = val;
                val = 0;
                if (matrixAsString.charAt(i) == '\n') 
                {
                    numRows++;
                }
            } 
            else
            {
                val = 10 * val + (matrixAsString.charAt(i) - '0');
            }
        }
        matrix[numberOfElements++] = val;
        numRows++;
        numColumns = numberOfElements / numRows;
    }

    int getColumnsCount()
    {
        return numColumns;
    }

    int getRowsCount()
    {
        return numRows;
    }

    int[] getRow(int n)
    {
        int[] row = new int[numColumns];
        for (int i = 0; i < numColumns; i++)
        {
            row[i] = matrix[n * numColumns + i];
        }
        return row;
    }

    int[] getColumn(int n)
    {
        int[] column = new int[numRows];
        for (int i = 0; i < numRows; i++)
        {
            column[i] = matrix[numColumns * i + n];
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
