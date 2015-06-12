package com.ticketmaster.servos.util;

import com.ticketmaster.servos.util.CreditCardUtils.CardType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardUtilsTest {
    private static final String[] VISA_VALID_NUMBERS = {
            "4916560685171348",
            "4539307952093616",
            "4556064665339137",
            "4024007192030285",
            "4929071219967222"
    };

    private static final String[] MASTER_CARD_VALID_NUMBERS = {
            "5195841618692702",
            "5405309473606973",
            "5131523182318982",
            "5236418135475175",
            "5143017468245106"
    };

    private static final String[] DISCOVER_VALID_NUMBERS = {
            "6011457616776841",
            "6011903828417138",
            "6011415041763016",
            "6011649037588231",
            "6011741839625293"
    };

    private static final String[] AMEX_VALID_NUMBERS = {
            "348984545856672",
            "346564851071231",
            "347457479254736",
            "340889290425342",
            "349459632566517"
    };

    private static final String[] INVALID_NUMBERS = {
            "4111111111111114",
            "5490123456789123",
            "378161408561558"
    };

    @Test
    public void itShouldReturnVisaType() {
        for (int i = 0; i < VISA_VALID_NUMBERS.length; i++) {
            assertEquals(CardType.detect(VISA_VALID_NUMBERS[i]),
                    CardType.VISA);
        }
    }

    @Test
    public void itShouldReturnMasterCardType() {
        for (int i = 0; i < VISA_VALID_NUMBERS.length; i++) {
            assertEquals(CardType.detect(MASTER_CARD_VALID_NUMBERS[i]),
                    CardType.MASTERCARD);
        }
    }

    @Test
    public void itShouldReturnAmexType() {
        for (int i = 0; i < AMEX_VALID_NUMBERS.length; i++) {
            assertEquals(CardType.detect(AMEX_VALID_NUMBERS[i]),
                    CardType.AMERICAN_EXPRESS);
        }
    }

    @Test
    public void itShouldReturnDiscoverType() {
        for (int i = 0; i < DISCOVER_VALID_NUMBERS.length; i++) {
            assertEquals(CardType.detect(DISCOVER_VALID_NUMBERS[i]),
                    CardType.DISCOVER);
        }
    }

    @Test
    public void itShouldReturnUnknownType() {
        assertEquals(CardType.detect("0983405345"),
                CardType.UNKNOWN);
    }

    @Test
    public void itShouldValidateVisaNumbers() {
        for (int i = 0; i < VISA_VALID_NUMBERS.length; i++) {
            assertTrue(CreditCardUtils.luhnTest(VISA_VALID_NUMBERS[i]));
        }
    }

    @Test
    public void itShouldValidateMasterCardNumbers() {
        for (int i = 0; i < MASTER_CARD_VALID_NUMBERS.length; i++) {
            assertTrue(CreditCardUtils.luhnTest(MASTER_CARD_VALID_NUMBERS[i]));
        }
    }

    @Test
    public void itShouldValidateDiscoverNumbers() {
        for (int i = 0; i < DISCOVER_VALID_NUMBERS.length; i++) {
            assertTrue(CreditCardUtils.luhnTest(DISCOVER_VALID_NUMBERS[i]));
        }
    }

    @Test
    public void itShouldValidateAmexNumbers() {
        for (int i = 0; i < AMEX_VALID_NUMBERS.length; i++) {
            assertTrue(CreditCardUtils.luhnTest(AMEX_VALID_NUMBERS[i]));
        }
    }

    @Test
    public void itShouldInvalidateInvalidNumbers() {
        for (int i = 0; i < INVALID_NUMBERS.length; i++) {
            assertFalse(CreditCardUtils.luhnTest(INVALID_NUMBERS[i]));
        }
    }
}

