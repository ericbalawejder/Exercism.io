class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        return String.valueOf(numberToCheck)
                .chars()
                .mapToObj(c -> (char) c)
                .map(i -> Character.getNumericValue(i))
                .map(i -> (int) Math.pow(i, String.valueOf(numberToCheck).length()))
                .reduce(0, Integer::sum) == numberToCheck;
    }

}
