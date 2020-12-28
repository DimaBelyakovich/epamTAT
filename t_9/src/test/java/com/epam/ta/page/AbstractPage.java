package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected final Logger logger = LogManager.getRootLogger();

	protected abstract AbstractPage openPage();
	protected final int WAIT_TIMEOUT_SECONDS = 10000000;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AbstractPage sleep() {
		driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		return this;
	}
}
