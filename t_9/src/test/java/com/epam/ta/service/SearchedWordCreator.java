package com.epam.ta.service;

import java.io.UnsupportedEncodingException;

public class SearchedWordCreator {
    public static final String SEARCHED_BRAND = "testdata.search.brand";
    public static final String SEARCHED_CATEGORY = "testdata.search.category";

    public static String getSearchedBrand(){
        return TestDataReader.getTestData(SEARCHED_BRAND);
    }

    public static String getSearchedCategory() throws UnsupportedEncodingException {
        return new String(TestDataReader.getTestData(SEARCHED_CATEGORY)
                .getBytes("ISO-8859-1"), "UTF-8");
    }
}
