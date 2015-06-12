package com.ticketmaster.servos.util;

import java.util.regex.Pattern;

public final class CreditCardUtils {
    private CreditCardUtils() { }

    static final int CVV_CODE_LENGTH = 3;

    public enum CardType {

        UNKNOWN,
        VISA("^4[0-9]{12}(?:[0-9]{3})?$", "VISA", 3),
        MASTERCARD("^5[1-5][0-9]{14}$", "MASTERCARD", 3),
        AMERICAN_EXPRESS("^3[47][0-9]{13}$", "AMEX", 4),
        DISCOVER("^6(?:011|5[0-9]{2})[0-9]{12}$", "DISC", 3);

        private Pattern pattern;
        private String name;
        private int cvvCodeLength;

        CardType() {
            this.pattern = null;
            this.name = "UNKNOWN";
            this.cvvCodeLength = CVV_CODE_LENGTH;
        }

        CardType(String pattern, String name, int cvvCodeLength) {
            this.pattern = Pattern.compile(pattern);
            this.name = name;
            this.cvvCodeLength = cvvCodeLength;
        }

        public String getName() {
            return name;
        }

        public static CardType detect(String cardNumber) {

            for (CardType cardType : CardType.values()) {
                if (null == cardType.pattern) continue;
                if (cardType.pattern.matcher(cardNumber).matches()) return cardType;
            }

            return UNKNOWN;
        }

        public int getCvvCodeLength() {
            return cvvCodeLength;
        }
    }

    /**
     * @param cardNumber - credit card number
     * @return - true if passes luhntest
     */
    // CHECKSTYLE.OFF: MagicNumberCheck
    public static boolean luhnTest(String cardNumber) {
        int sumOdd = 0, sumEven = 0;
        String reverse = new StringBuffer(cardNumber).reverse().toString();
        for (int i = 0; i < reverse.length(); i++) {
            int digit = Character.digit(reverse.charAt(i), 10);
            if (i % 2 == 0) {
                sumOdd += digit;
            } else {
                sumEven += 2 * digit;
                if (digit >= 5) {
                    sumEven -= 9;
                }
            }
        }
        return (sumOdd + sumEven) % 10 == 0;
    }
    // CHECKSTYLE.ON: MagicNumberCheck
}
