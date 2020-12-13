package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPage {
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AbstractPage sleep() {
        try{
            Thread.sleep(WAIT_TIMEOUT_SECONDS.toMillis());
            return this;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return this;
        }
    }

    public abstract AbstractPage openPage(String url);
}
