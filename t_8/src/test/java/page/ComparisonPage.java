package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparisonPage extends AbstractPage{
    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='zvRJMhRW-w']")
    private List<WebElement> addedItems;

    public int getNumOfAddedItems(){
        return addedItems.size();
    }

    @Override
    public ComparisonPage openPage(String url) {
        return this;
    }
}
