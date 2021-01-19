package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage
{
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected final Logger logger = LogManager.getRootLogger();

	protected abstract AbstractPage openPage();
	protected final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
}
