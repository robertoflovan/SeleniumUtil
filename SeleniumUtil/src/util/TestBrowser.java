package util;

import org.openqa.selenium.WebDriver;

public abstract class TestBrowser {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void open();
	
	public void close(){
		driver.close();
	}
	
	
	public abstract void propertyPrivateMode();
	public abstract void propertyMaximized();
	
}
