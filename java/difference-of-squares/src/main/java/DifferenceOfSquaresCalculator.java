class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int n) {
        return (int) Math.pow((n * (n + 1)) / 2.0, 2);
    }

    int computeSumOfSquaresTo(int n) {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }

    int computeDifferenceOfSquares(int n) {
        return computeSquareOfSumTo(n) - computeSumOfSquaresTo(n);
    }

}
