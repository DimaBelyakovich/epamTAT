package com.epam.ta.page;


import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SalePage extends AbstractPage{
    private static final String URL = "https://pokupki.market.yandex.ru/special/new-year?track=logo";

    @FindBy(xpath = "//div[@class='b_1KTAcrzTNV b_2HCWRBmkmf b_gSn9wsS6d1 brandTheme_default']")
    private List<WebElement> theMostProfitable;

    public List<String> getDiscounts(){
        CustomWaits.waitForPageLoaded(driver);
        CustomWaits.waitForElementLocated(driver, "//div[text()='Самое выгодное']");
        return theMostProfitable.stream().map(i->i.getText()).collect(Collectors.toList());
    }

    public SalePage(WebDriver driver) {
        super(driver);
        CustomWaits.waitForPageLoaded(driver);
    }

    @Override
    public SalePage openPage() {
        driver.navigate().to(URL);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
