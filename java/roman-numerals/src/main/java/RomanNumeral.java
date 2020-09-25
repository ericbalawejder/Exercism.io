import java.util.List;

class RomanNumeral {

    final private String romanNumeral;

    RomanNumeral(int number) {
        this.romanNumeral = arabicToRoman(number);
    }

    String getRomanNumeral() {
        return romanNumeral;
    }

    private String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
        List<RomanNumerals> romanNumerals = RomanNumerals.getReverseSortedValues();

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumerals currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                stringBuilder.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }
}