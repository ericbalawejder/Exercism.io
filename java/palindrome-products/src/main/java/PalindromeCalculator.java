import java.util.Arrays;
import java.util.List;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

class PalindromeCalculator {
    
    public static void main(String[] args) {
        PalindromeCalculator palindromeCalculator = new PalindromeCalculator();
        System.out.println(palindromeCalculator.getPalindromeProductsWithFactors(10, 99));
    }

    Multimap<Long, List<Integer>> getPalindromeProductsWithFactors(int start, int end) {
        Multimap<Long, List<Integer>> palindromes = LinkedHashMultimap.create();
        
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                Long product = (long) (i * j);
                if (isPalindrome(product))
                {
                    palindromes.put(product, Arrays.asList(i, j));
                }
            }
        }
        // return the last <key, values> pair!!!
        return palindromes;
    }

    private boolean isPalindrome(long number) {
        return number == reverseInt(number);
    }

    private long reverseInt(long number) {
        long reversedNumber = 0L;

        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }

}
