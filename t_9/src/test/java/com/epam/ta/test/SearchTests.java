package com.epam.ta.test;

import com.epam.ta.page.MainPage;
import com.epam.ta.service.FindContains;
import com.epam.ta.service.SearchedWordCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class SearchTests extends CommonConditions{
    @Test
    public void searchResultTest() throws UnsupportedEncodingException {

        final String searchedBrand = SearchedWordCreator.getSearchedBrand();
        final String searchedCategory = SearchedWordCreator.getSearchedCategory();

        MainPage mainPage = new MainPage(driver)
                                .openPage()
                                .setupLocation("Москва")
                                .search(searchedBrand.toLowerCase());
        boolean isBrandContains = FindContains.findContains(mainPage.searchResultBrand(), searchedBrand);
        Assert.assertTrue(isBrandContains);

        mainPage.openPage()
                .search(searchedCategory.toLowerCase());
        boolean isCategoryContains = FindContains.findContains(mainPage.searchResultCategory(), searchedCategory);
        Assert.assertTrue(isCategoryContains);
    }
}
