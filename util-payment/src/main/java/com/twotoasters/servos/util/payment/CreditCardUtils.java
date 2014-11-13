package com.twotoasters.servos.util.payment;

import android.content.Context;

import java.util.regex.Pattern;

/**
 * Util for obtaining type of credit card and validating with Luhn Test.
 */
public final class CreditCardUtils {
    private CreditCardUtils() { }


    public enum CardType {

        UNKNOWN,
        VISA("^4[0-9]{12}(?:[0-9]{3})?$", R.string.visa_abrev, 3),
        MASTERCARD("^5[1-5][0-9]{14}$", R.string.mastercard_abrev, 3),
        AMERICAN_EXPRESS("^3[47][0-9]{13}$", R.string.american_express_abrev, 4),
        DISCOVER("^6(?:011|5[0-9]{2})[0-9]{12}$", R.string.discover_abrev, 3);

        private Pattern pattern;
        private int name;
        private int cvvCodeLength;

        CardType() {
            this.pattern = null;
            this.cvvCodeLength = 3;
        }

        CardType(String pattern, int name, int cvvCodeLength) {
            this.pattern = Pattern.compile(pattern);
            this.name = name;
            this.cvvCodeLength = cvvCodeLength;
        }

        public String getName(Context context) {
            return context.getString(name);
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
}
