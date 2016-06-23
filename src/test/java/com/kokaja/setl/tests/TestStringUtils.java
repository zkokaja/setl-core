package com.kokaja.setl.tests;

public class TestStringUtils {

    public static String concat(String... strings) {

        return concat(null, strings);
    }

    public static String concat(Character delimiter, String... strings) {
        StringBuilder sb = new StringBuilder();

        String delimiterStr = (delimiter == null) ? "\r\n" : delimiter.toString();
        for (String string : strings) {
            sb.append(string);
            sb.append(delimiterStr);
        }

        return sb.toString();
    }

}
