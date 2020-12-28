package com.epam.ta.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LocaleCreator {
    public static final String CITY = "testdata.location.city";
    public static final String MONEY_FORMAT = "testdata.location.money";

    public static Map<String,String> getLocale() throws UnsupportedEncodingException {
        Map<String, String> locale = new HashMap<>();
        String city = new String(TestDataReader.getTestData(CITY)
                .getBytes("ISO-8859-1"), "UTF-8");
        String moneyFormat = new String(TestDataReader.getTestData(MONEY_FORMAT)
                .getBytes("ISO-8859-1"), "UTF-8");
        locale.put(city, moneyFormat);
        return locale;
    }
}
