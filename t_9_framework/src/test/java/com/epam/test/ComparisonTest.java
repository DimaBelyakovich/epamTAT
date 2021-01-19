package com.epam.test;

import com.epam.model.Item;
import com.epam.page.ComparisonPage;
import com.epam.page.MainPage;
import com.epam.service.TestDataReader;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ComparisonTest extends CommonConditions{
    private static final String LOCATION_PROPERTY = "testdata.location.city";
    private static final String CATEGORY_TYPE1 = "testdata.category.type1";
    private static final String CATEGORY_NAME1 = "testdata.category.name1";
    private static final String PAGE_NAME = "Сравнение товаров";

    @Test
    public void comparisonOneTypeWithoutAuthorizationTest() throws UnsupportedEncodingException {
        String city = TestDataReader.getTestDataRus(LOCATION_PROPERTY);
        String type = TestDataReader.getTestDataRus(CATEGORY_TYPE1);
        String name = TestDataReader.getTestDataRus(CATEGORY_NAME1);
        LinkedList<Item> addedItems = new LinkedList<>();

        ComparisonPage comparisonPage = new MainPage(driver)
                                    .openPage()
                                    .setupCity(city)
                                    .closePopUp()
                                    .goToCategory(type, name)
                                    .createItemList()
                                    .addToComparison(1, addedItems)
                                    .goToItem(2)
                                    .creatItem()
                                    .addToComparison(addedItems)
                                    .goToComparisonPageFromPopUp()
                                    .createItemsList();

        assertThat(comparisonPage.getPageTitle(), is(equalTo(PAGE_NAME)));
        assertThat(comparisonPage.getItems(), is(equalTo(addedItems)));
    }

    private static final String CATEGORY_TYPE2 = "testdata.category.type2";
    private static final String CATEGORY_NAME2 = "testdata.category.name2";
    @Test
    public void comparisonDifTypesWithoutAuthorizationTest() throws UnsupportedEncodingException{
        String city = TestDataReader.getTestDataRus(LOCATION_PROPERTY);
        String type1 = TestDataReader.getTestDataRus(CATEGORY_TYPE1);
        String name1 = TestDataReader.getTestDataRus(CATEGORY_NAME1);
        String type2 = TestDataReader.getTestDataRus(CATEGORY_TYPE2);
        String name2 = TestDataReader.getTestDataRus(CATEGORY_NAME2);
        LinkedList<Item> addedItemsFirstCategory = new LinkedList<>();
        LinkedList<Item> addedItemsSecondCategory = new LinkedList<>();

        ComparisonPage comparisonPage = new MainPage(driver)
                                    .openPage()
                                    .setupCity(city)
                                    .closePopUp()
                                    .goToCategory(type1, name1)
                                    .createItemList()
                                    .addToComparison(1, addedItemsFirstCategory)
                                    .addToComparison(10, addedItemsFirstCategory)
                                    .closePopUp()
                                    .goToCategory(type2, name2)
                                    .createItemList()
                                    .addToComparison(2, addedItemsSecondCategory)
                                    .addToComparison(5, addedItemsSecondCategory)
                                    .goToComparisonPageFromPopUp();

        assertThat(comparisonPage.getPageTitle(), is(equalTo(PAGE_NAME)));

    }
}
