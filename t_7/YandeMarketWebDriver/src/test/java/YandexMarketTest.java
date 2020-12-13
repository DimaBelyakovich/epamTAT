import org.apache.tools.ant.types.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;


public class YandexMarketTest extends Assertions {
    public static final String FIRST_LINK = "https://market.yandex.by/product--smartfon-xiaomi-redmi-note-8-pro-6-64gb/573324027?lr=0";
    public static final String SECOND_LINK = "https://market.yandex.by/catalog--smartfony-v-breste/16814639/list?hid=91491&cpa=0&glfilter=16816262%3A16816264&onstock=1&lr=0&local-offers-first=0";
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://market.yandex.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAddedLikedItems() {

        driver.get(FIRST_LINK);
        WebElement likeButton = new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_2UmyXf5e76']")));
        likeButton.click();

        driver.get(SECOND_LINK);
        List<WebElement> likeButtons = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_2UmyXf5e76']")));
        likeButton = likeButtons.get(7);
        likeButton.click();

        WebElement likedButton = new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-apiary-widget-name='@MarketNode/HeaderWishlistButton']")));
        likedButton.click();

        List<WebElement> likedItems = driver.findElements(By.xpath("//article[@class='_1_IxNTwqll cia-vs cia-cs']"));
        WebElement numberOfItems = driver.findElement(By.xpath("//span[@class='mSwwwbBehQ']"));

        int expectedResult = parseInt(numberOfItems.getText());
        Assert.assertEquals(expectedResult, likedItems.size());
    }



}
