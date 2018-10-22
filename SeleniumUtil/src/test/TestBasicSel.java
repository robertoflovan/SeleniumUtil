package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

public class TestBasicSel {

	WebDriver driver;
	
	public static void main(String[] args) {
		
		TestBasicSel t = new TestBasicSel();
		
		try {
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RF43496\\Documents\\Roberto Flores\\lib\\Selenium\\Driver\\chromedriver.exe");

		
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		options.addArguments("--start-maximized");
		
		
		
		t.driver = new ChromeDriver(options);
		
		
		t.driver.get("http://newtours.demoaut.com/");
		
		
			
		
		WebElement user = t.driver.findElement(By.name("userName"));
		user.sendKeys("asd");
		
		WebElement pass = t.driver.findElement(By.name("password"));
		pass.sendKeys("asd");
		
		//pass.submit();
		WebElement button = t.driver.findElement(By.name("login"));
		button.click();
		
		Select passengers = new Select(t.driver.findElement(By.name("passCount")));
		passengers.selectByIndex(2);
		
		Select from = new Select(t.driver.findElement(By.name("fromPort")));
		from.selectByIndex(4);
		
		
		Thread.sleep(5000);
		t.driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.driver.quit();
		}  // Let the user actually see something!
	}
	
}
