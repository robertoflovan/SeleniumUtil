package util;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class TestUtil {

	
	private TestBrowser browser;
	
	private int waitTimeSeconds;
	
	
	//Constructor
	public TestUtil(TestBrowser browser) {
		this.browser = browser;
		this.waitTimeSeconds = 15;
	}
	
	//Generic actions methods
	public void click(By by){
		waitWebElement(by).click();
	}
	
	public void sendKeys(By by, String str){
		waitWebElement(by).sendKeys(str);
	}
	
	public void get(String url){
		browser.getDriver().get(url);
	}
	
	public String getText(By by){
		return waitWebElement(by).getText();
	}
	
	//Wait
	
	private WebElement waitWebElement(By by){
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(browser.getDriver()).withTimeout(Duration.ofSeconds(waitTimeSeconds))
		        .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
		  public WebElement apply(WebDriver driver) {
		  return driver.findElement(by);
		}});
		return element;
	}
	
	public void hardWait(int seg){
		try {
			Thread.sleep(seg*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en hardWait");
			e.printStackTrace();
		}
	}
	
	public void waitForLoadPage() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), 30);
        wait.until(pageLoadCondition);
    }

	//Getters and setters

	public TestBrowser getBrowser() {
		return browser;
	}

	public void setBrowser(TestBrowser browser) {
		this.browser = browser;
	}

	public int getWaitTimeSeconds() {
		return waitTimeSeconds;
	}

	public void setWaitTimeSeconds(int waitTimeSeconds) {
		this.waitTimeSeconds = waitTimeSeconds;
	}

	
		
	
	
	
	
	
	
}
