// Write some code to determine whether a number is an Armstrong number.
// Armstrong number: https://en.wikipedia.org/wiki/Narcissistic_number
class ArmstrongNumbers
{
    boolean isArmstrongNumber(int numberToCheck)
    {
        int armstrongNumber = numberToCheck;
        int numberOfDigits = (int)(Math.log10(armstrongNumber) + 1);
        int[] digits = new int[numberOfDigits];
        for (int i = 0; i < numberOfDigits; i++)
        {
            digits[i] = armstrongNumber % 10;
            armstrongNumber = armstrongNumber / 10;
        }
        int sum = 0;
        for (int digit : digits)
        {
            sum += (int)Math.pow(digit, numberOfDigits);
        }
        return sum == numberToCheck;
    }
}
