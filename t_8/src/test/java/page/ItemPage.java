package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ItemPage extends AbstractPage{

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_1CXljk9rtd']")
    private WebElement addToComparisonButton;

    @FindBy(xpath = "//div[@class='_3oDLePObQ1']")
    private WebElement comparisonButton;

    public ItemPage addToComparison(){
        addToComparisonButton.click();
        return this;
    }

    public WebDriver goToComparison(){
        comparisonButton.click();
        return this.driver;
    }

    @Override
    public ItemPage openPage(String url) {
        sleep();
        driver.get(url);
        return this;
    }
}
