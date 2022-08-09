package org.example;

public class DivisibleChallenge {

    private static final int START_POINT = 1;
    private static final int END_POINT = 100;
    private static final int DIVISIBLE_NUMBER_1 = 3;
    private static final String MESSAGE_1 = "Visual";
    private static final int DIVISIBLE_NUMBER_2 = 5;
    private static final String MESSAGE_2 = "Nuts";
    private static final int DIVISIBLE_NUMBER_COMBINE = DIVISIBLE_NUMBER_1 * DIVISIBLE_NUMBER_2;
    private static final String MESSAGE_COMBINE = "Visual Nuts";
    private static final String SEPARATOR = "\n";

    public static String customMessageForDivisibleNumber(int start, int end){
        if(start > end) return "";

        StringBuilder stringBuilder = new StringBuilder();

        for (int number = start; number <= end; number++) {
            String currentValue;

            if (number % DIVISIBLE_NUMBER_COMBINE == 0) currentValue = MESSAGE_COMBINE;
            else if (number % DIVISIBLE_NUMBER_1 == 0) currentValue = MESSAGE_1;
            else if (number % DIVISIBLE_NUMBER_2 == 0) currentValue = MESSAGE_2;
            else currentValue = String.valueOf(number);

            stringBuilder.append(currentValue + SEPARATOR);
        }

        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(customMessageForDivisibleNumber(START_POINT, END_POINT));
    }
}
