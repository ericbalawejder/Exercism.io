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
        print(matrix.getColumn(0));
    }
    
    private int[] matrix;
    private int numberOfRows = 0;
    private int numberOfColumns;

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
                    numberOfRows++;
                }
            } 
            else
            {
                val = 10 * val + (matrixAsString.charAt(i) - '0');
                //val = Integer.parseInt(matrixAsString.charAt(i));
            }
        }
        matrix[numberOfElements++] = val;
        numberOfRows++;
        numberOfColumns = numberOfElements / numberOfRows;
    }

    int getColumnsCount()
    {
        return numberOfColumns;
    }

    int getRowsCount()
    {
        return numberOfRows;
    }

    int[] getRow(int n)
    {
        int[] row = new int[numberOfColumns];
        for (int i = 0; i < numberOfColumns; i++)
        {
            row[i] = matrix[n * numberOfColumns + i];
        }
        return row;
    }

    int[] getColumn(int n)
    {
        int[] column = new int[numberOfRows];
        for (int i = 0; i < numberOfRows; i++)
        {
            column[i] = matrix[numberOfColumns * i + n];
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
