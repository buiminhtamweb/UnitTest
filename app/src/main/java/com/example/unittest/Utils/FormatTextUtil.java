package com.example.unittest.Utils;

public class FormatTextUtil {

    public static String getPhoneNumber(String numberPhone) {
        if (numberPhone == null) return "";
        if (numberPhone.equals("")) return "";
        String phoneTrim = numberPhone.trim().replace(" ", "");
        String firstChar = String.valueOf(phoneTrim.charAt(0));
        if (phoneTrim.length() < 9 || phoneTrim.length() > 15) return "";
        else if (phoneTrim.contains("+84")) {
            return phoneTrim.replace("+84", "0");
        } else if (firstChar.equals("0")) {
            return phoneTrim;
        } else return "0" + phoneTrim;


    }
}
