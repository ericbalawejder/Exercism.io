class PhoneNumber {

    private final String phoneNumber;

    PhoneNumber(String phoneNumber) {
        this.phoneNumber = northAmericanNumberingPlan(getDigits(phoneNumber));
    }

    String getNumber() {
        return this.phoneNumber;
    }

    private String getDigits(String number) {
        if (number.matches(".*[A-Za-z]+.*")) {
            throw new IllegalArgumentException("letters not permitted");
        } else if (number.matches(".*[@:!]+.*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        } else {
            return number.replaceAll("[\\s()+-.]", "");
        }
    }

    private String northAmericanNumberingPlan(String number) {
        if (number.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        } else if (number.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        } else if (number.length() == 11) {
            return containsCountryCode(number);
        } else {
            return tenDigitDialing(number);
        }
    }

    private String tenDigitDialing(String number) {
        if (number.startsWith("0")) {
            throw new IllegalArgumentException("area code cannot start with zero");
        } else if (number.startsWith("1")) {
            throw new IllegalArgumentException("area code cannot start with one");
        } else if (number.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        } else if (number.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        } else {
            return number;
        }
    }

    private String containsCountryCode(String number) {
        if (!number.startsWith("1")) {
            throw new IllegalArgumentException("11 digits must start with 1");
        }
        return tenDigitDialing(number.substring(1));
    }

}
