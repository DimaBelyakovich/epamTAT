package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchLineInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='_2PqWK2TYHQ']")
    private List<WebElement> searchedBrand;

    @FindBy(xpath = "//h3[@class='_3dCGE8Y9v3 cLo1fZHm2y']")
    private List<WebElement> searchedCategory;

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

    @Override
    public MainPage openPage(String url) {
        sleep();
        driver.get(url);
        return this;
    }
}
