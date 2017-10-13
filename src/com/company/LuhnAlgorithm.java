package com.company;

public class LuhnAlgorithm {


    /**
     * this is a slower speed but more readable version of Luhn 10
     *
     * @param ccNum
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isAValidCard(String ccNum) throws IllegalArgumentException {

        if (ccNum.length() != 16)
            throw new IllegalArgumentException("invalid Credit Card Number");

        StringBuffer oddNum = new StringBuffer();
        StringBuffer evenNum = new StringBuffer();
        oddNum.setLength(0);
        evenNum.setLength(0);


        for (int counter = 0; counter < ccNum.length(); counter++) {
            if (counter % 2 == 0) {
                // add to evenNum
                evenNum.append(ccNum.charAt(counter));
            } else {
                // add to oddNum
                oddNum.append(ccNum.charAt(counter));

            }

        }

        return ((sumOdd(oddNum) + sumEven(evenNum)) % 10 == 0);
    }

    /**
     * This is a quicker speed and space conscious version of Luhn 10
     *
     * @param ccNum
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isAValidCardSpeed(String ccNum) throws IllegalArgumentException {


        if (ccNum.length() < 16 && ccNum.length() > 19)
            throw new IllegalArgumentException("invalid Credit Card Number");

        StringBuffer oddNum = new StringBuffer();
        StringBuffer evenNum = new StringBuffer();
        oddNum.setLength(0);
        evenNum.setLength(0);
        int oddSum = 0;
        int evenSum = 0;


        for (int counter = 0; counter < ccNum.length(); counter++) {
            if (counter % 2 == 0) {
                // add to evenNum

                int temp = Integer.valueOf(ccNum.charAt(counter) + "").intValue() * 2;
                if (temp >= 10)
                    temp += -9;

                evenSum += temp;

            } else {
                // add to oddNum

                oddSum += Integer.valueOf(ccNum.charAt(counter) + "").intValue();

            }

        }

        return ((oddSum + evenSum) % 10 == 0);

    }

    private static int sumOdd(StringBuffer oddNum) {

        int sum = 0;

        for (int counter = 0; counter < oddNum.length(); counter++) {

            sum += Integer.valueOf(oddNum.charAt(counter) + "").intValue();

        }
        // odd number you add them up

        return sum;
    }

    private static int sumEven(StringBuffer oddNum) {

        // even number you double and subtract 9


        int sum = 0;

        for (int counter = 0; counter < oddNum.length(); counter++) {

            int temp = Integer.valueOf(oddNum.charAt(counter) + "").intValue() * 2;
            if (temp >= 10)
                temp += -9;

            sum += temp;

        }
        // odd number you add them up

        return sum;

    }


    public static void main(String[] argv) {

        boolean validCard = LuhnAlgorithm.isAValidCard("4847352989263094");
        validCard = validCard;

        validCard = LuhnAlgorithm.isAValidCardSpeed("4847352989263094");
        validCard = validCard;

        validCard = LuhnAlgorithm.isAValidCardSpeed("1234567890123456");
        validCard = validCard;


        try {

            validCard = LuhnAlgorithm.isAValidCard("484735298926309");
            validCard = validCard;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            validCard = LuhnAlgorithm.isAValidCard("4847352989263093");
            validCard = validCard;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

}
