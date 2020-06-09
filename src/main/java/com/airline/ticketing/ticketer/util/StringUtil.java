package com.airline.ticketing.ticketer.util;

import org.omg.CORBA.BAD_PARAM;

public class StringUtil {

    public static String formatCardNumber(String cardNumberOriginal) {
        String cardNoStrOnlyNum = cardNumberOriginal.replaceAll("[^\\d.]", "");
        if (cardNoStrOnlyNum.length() != 16) {
            throw new BAD_PARAM("card number must be exactly 16 digits: " + cardNumberOriginal);
        }
        return cardNoStrOnlyNum.substring(0, 5) + "******" + cardNoStrOnlyNum.substring(12, 15);
    }
}
