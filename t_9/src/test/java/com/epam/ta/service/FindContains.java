package com.epam.ta.service;

import java.util.List;

public class FindContains {
    public static boolean findMatches(List<String> list, String format){
        boolean matches = false;
        for (String st : list) {
            matches = st.equals(format);
        }
        return matches;
    }

    public static boolean findContains(List<String> findsList, String searchedString){
        boolean contains = false;
        for (String st: findsList) {
            contains = st.contains(searchedString.toLowerCase()) ? true : false;
        }
        return contains;
    }
}
