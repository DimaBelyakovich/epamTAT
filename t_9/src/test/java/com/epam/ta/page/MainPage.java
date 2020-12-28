package com.epam.ta.page;

import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends AbstractPage {
    private static final String MAIN_URL = "https://market.yandex.by/";

    public MainPage(WebDriver driver) {
        super(driver);
        CustomWaits.waitForPageLoaded(driver);
    }

    @FindBy(xpath = "//div[@class='_7v6Uf-UYpr _2AL_nfH3zl']/a[@rel='nofollow noopener']")
    private WebElement saleButton;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchLineInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='_2EPSjI-GdM _1U1dDjJdGe _1TU3qsnDUb aASzJFnmRI _1xlw1z4vqj']")
    private WebElement logInButton;

    @FindBy(xpath = "//div[@class='name oXsoOx4Bjr _3YDYAQaiqc _3czXWOU0_G']")
    private List<WebElement> searchedBrand;

    @FindBy(xpath = "//h3[@class='_3dCGE8Y9v3 cLo1fZHm2y']")
    private List<WebElement> searchedCategory;

    @FindBy(xpath = "//button[@class='MOYcCv2eIJ _3UND8GjCtL']")
    private WebElement changeCityButton;

    @FindBy(xpath = "//input[@class='_1pVZ3jklLF']")
    private WebElement cityInput;

    @FindBy(xpath = "//button[@class='_2EPSjI-GdM _2s55WErgIp aASzJFnmRI _3OsPkXYN80']")
    private WebElement continueChangeCityButton;

    @FindBy(xpath = "//a[@class='aSUR-uUgeo']")
    private List<WebElement> hoverHintCity;

    @FindBy(xpath = "//div[@class='_3RDrvB5y7W _1Vd4y0E_v8']")
    private WebElement profileButton;

    public String getLoggedUserName(){
        CustomWaits.waitForElementClickable(driver, profileButton);
        profileButton.click();
        WebElement loggedUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_10BSdt90pf _3rYu_TSC-x']")));
        return loggedUser.getText();
    }

    public SalePage goToSalePage(){
        saleButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return new SalePage(driver);
    }

    public MainPage search(String searchLine){
        searchLineInput.sendKeys(searchLine);
        searchButton.click();
        return this;
    }

    public List<String> searchResultCategory(){
        return searchedCategory.stream().map(item -> item.getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public List<String> searchResultBrand(){
        return searchedBrand.stream().map(item -> item.getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public MainPage setupLocation(String city){
        changeCityButton.click();
        CustomWaits.waitForPageLoaded(driver);
        cityInput.sendKeys(city);
        hoverHintCity.get(0).click();
        continueChangeCityButton.click();
        logger.info("location set upped");
        CustomWaits.waitForPageLoaded(driver);
        return new MainPage(driver);
    }

    public MainPage openPage(String url) {
        driver.navigate().to(url);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public MainPage openPage() {
        sleep();
        driver.navigate().to(MAIN_URL);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
