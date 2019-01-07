import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

class PalindromeCalculator {

    SortedMap<Long, List<List<Integer>>> getPalindromeProductsWithFactors(int start, int end) {
        SortedMap<Long, List<List<Integer>>> palindromes = new TreeMap<>();

        if (start > end) {
            throw new IllegalArgumentException(
                    String.format("invalid input: min is %d and max is %d", start, end));
        } else {
            for (int i = start; i <= end; i++) {
                for (int j = i; j <= end; j++) {
                    Long product = (long) (i * j);
                    if (isPalindrome(product))
                    {
                        List<List<Integer>> factors = new ArrayList<>();
                        if (palindromes.containsKey(product)) {
                            factors.addAll(palindromes.get(product));
                            factors.add(Arrays.asList(i, j));
                            palindromes.put(product, factors);
                        } else {
                            factors.add(Arrays.asList(i, j));
                            palindromes.put(product, factors);
                        }
                    }
                }
            }
        }
        if (palindromes.isEmpty()) {
            throw new NoSuchElementException(
                    String.format("no palindrome with factors in the range %d to %d", start, end));
        }
        return Collections.unmodifiableSortedMap(palindromes);
    }

    private boolean isPalindrome(long number) {
        return number == reverseNumber(number);
    }

    private long reverseNumber(long number) {
        long reversedNumber = 0L;

        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }

}
