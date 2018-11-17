package com.sunmonkeyapps.doordash.util;

public class UiUtil {

    public static String formatPhone(String phone) {
        String formatPhone="";
        //+16509989233 -> (650)998 - 9233
        formatPhone = " (" + phone.substring(2, 5) +
                ") " + phone.substring(5, 8) + " - " + phone.substring(8);
        return formatPhone;

    }
}
