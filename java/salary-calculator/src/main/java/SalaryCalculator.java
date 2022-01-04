class SalaryCalculator {

    private static final int SALARY_PERCENTAGE = 1;
    private static final double SALARY_PENALTY = 0.15;
    private static final int BASE_SALARY = 1000;
    private static final int MAX_BASE_SALARY = 2000;
    private static final int MAX_SKIPPED_DAYS_ALLOWED = 5;
    private static final int REGULAR_MULTIPLIER_PER_PRODUCTS_SOLD = 10;
    private static final int BONUS_MULTIPLIER_PER_PRODUCTS_SOLD = 13;
    private static final int BONUS_THRESHOLD = 20;

    double multiplierPerDaysSkipped(int daysSkipped) {
        return daysSkipped > MAX_SKIPPED_DAYS_ALLOWED ?
                SALARY_PERCENTAGE - SALARY_PENALTY :
                SALARY_PERCENTAGE;
    }

    int multiplierPerProductsSold(int productsSold) {
        return productsSold > BONUS_THRESHOLD ?
                BONUS_MULTIPLIER_PER_PRODUCTS_SOLD :
                REGULAR_MULTIPLIER_PER_PRODUCTS_SOLD;
    }

    double bonusForProductSold(int productsSold) {
        return multiplierPerProductsSold(productsSold) * productsSold;
    }

    double finalSalary(int daysSkipped, int productsSold) {
        final double salary = BASE_SALARY * multiplierPerDaysSkipped(daysSkipped)
                + bonusForProductSold(productsSold);
        return salary > MAX_BASE_SALARY ? MAX_BASE_SALARY : salary;
    }

}
