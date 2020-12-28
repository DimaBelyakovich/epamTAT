package com.epam.ta.test;

import com.epam.ta.page.CategoryPage;
import com.epam.ta.service.FindContains;
import com.epam.ta.service.LocaleCreator;
import com.epam.ta.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class LocalizationTests extends CommonConditions {
    @Test
    public void changePriceFormat() throws UnsupportedEncodingException {
        Map<String,String> locale = LocaleCreator.getLocale();
        CategoryPage categoryPage = new CategoryPage(driver)
                                        .openPage();

        for (Map.Entry<String,String> e : locale.entrySet()){
            categoryPage.setupLocation(e.getKey());
            boolean isCategoryMatches = FindContains.findMatches(categoryPage.getPriceFormat(), e.getValue());
            assertThat(categoryPage.getCity(), is(equalTo(e.getKey())));
            Assert.assertTrue(isCategoryMatches);
        }
    }
}
