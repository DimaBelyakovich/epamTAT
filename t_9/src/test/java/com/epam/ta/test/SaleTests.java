package com.epam.ta.test;

import com.epam.ta.page.MainPage;
import com.epam.ta.page.SalePage;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SaleTests extends CommonConditions{

    @Test
    public void TheMostProfitableDiscountTest(){
        int numTheMostDiscount = 7;
        SalePage salePage = new MainPage(driver)
                                .openPage()
                                .setupLocation("Москва")
                                .goToSalePage();

        List<String> theMostDiscounts = salePage.getDiscounts();
        assertThat(theMostDiscounts.size(), is(equalTo(numTheMostDiscount)));
    }
}
