package test;

import org.apache.tools.ant.types.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PageObjectTests extends Assertions {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void testNumComparedItems() {
        List<AbstractPage> comparedItems = new ArrayList<>();

        CategoryPage addedItemFromList = new CategoryPage(driver)
                                            .openPage("https://market.yandex.by/catalog--mobilnye-telefony-v-minske/54726/list?lr=0&glfilter=4940921%3A13475069&onstock=1&hid=91491&local-offers-first=0")
                                            .addToComparison(1);
        comparedItems.add(addedItemFromList);

        ItemPage addedItemFromItemPage = new ItemPage(driver)
                                            .openPage("https://market.yandex.by/product--smartfon-samsung-galaxy-a31-64gb/661312003")
                                            .addToComparison();
        comparedItems.add(addedItemFromItemPage);

        ComparisonPage comparisonPage = new ComparisonPage(addedItemFromItemPage.goToComparison());

        int expectedResult = comparedItems.size();
        Assert.assertEquals(expectedResult, comparisonPage.getNumOfAddedItems());
    }

    @Test
    public void searchResultTest(){
        final String searchedBrand = "Samsung";
        final String searchedCategory = "ноутбук";

        MainPage mainPage = new MainPage(driver)
                                .openPage("https://market.yandex.by/?lr=0&rtr=157")
                                .search(searchedBrand.toLowerCase());
        boolean isBrandContains = findContains(mainPage.searchResultBrand(), searchedBrand);
        Assert.assertTrue(isBrandContains);


        mainPage.openPage("https://market.yandex.by/?lr=0&rtr=157")
                .search(searchedCategory.toLowerCase());
        boolean isCategoryContains = findContains(mainPage.searchResultCategory(), searchedCategory);
        Assert.assertTrue(isCategoryContains);
    }

    private boolean findContains(List<String> findsList, String searchedString){
        boolean contains = false;
        for (String st: findsList) {
            contains = st.contains(searchedString.toLowerCase()) ? true : false;
        }
        return contains;
    }
}
