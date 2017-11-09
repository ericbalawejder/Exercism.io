// Find the difference between the square of the sum and the sum of the squares 
// of the first N natural numbers. 
public class DifferenceOfSquaresCalculator
{
    int computeSquareOfSumTo(int n)
    {
        return (int) Math.pow((n * (n + 1)) / 2, 2);
    }
    
    int computeSumOfSquaresTo(int n)
    {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }
    
    int computeDifferenceOfSquares(int n)
    {
        return computeSquareOfSumTo(n) - computeSumOfSquaresTo(n);
    }
}
