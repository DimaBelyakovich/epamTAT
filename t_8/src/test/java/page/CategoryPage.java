package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CategoryPage extends AbstractPage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_1CXljk9rtd']")
    private List<WebElement> addToComparisonButtons;

    public CategoryPage addToComparison(Integer i){
        if (i >= 0 && i < addToComparisonButtons.size()) {
            WebElement compButton = addToComparisonButtons.get(i);
            sleep();
            compButton.click();
        }
        return this;
    }

    @Override
    public CategoryPage openPage(String url) {
        sleep();
        driver.get(url);
        return this;
    }
}
