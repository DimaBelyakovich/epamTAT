package com.epam.ta.page;

import com.epam.ta.model.User;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{
    private static final String LOGINPAGE_URL = "https://passport.yandex.ru/auth/add?origin=market_desktop_header&retpath=https%3A%2F%2Fmarket.yandex.ru%2F%3Flr%3D213";
    @FindBy(xpath = "//input[@data-t='field:input-login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@data-t='field:input-passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("login page created");
        CustomWaits.waitForPageLoaded(driver);
    }

    public LoginPage sendLogin(User user){
        loginInput.sendKeys(user.getUsername());
        logger.info("login send");
        CustomWaits.waitForPageLoaded(driver);
        submitButton.click();
        CustomWaits.waitForElementClickable(driver,passwordInput);
        return this;
    }

    public MainPage sendPassword(User user){
        passwordInput.sendKeys(user.getPassword());
        logger.info("password send");
        CustomWaits.waitForPageLoaded(driver);
        submitButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return new MainPage(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGINPAGE_URL);
        return this;
    }
}
