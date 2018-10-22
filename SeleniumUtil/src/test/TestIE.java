package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestIE {
	public static final String RUTA_DRIVER = "src/res/IEDriverServer.exe";
	public static void main(String[] args) {
		
		
		// set driver path
		 
		System.setProperty("webdriver.ie.driver",RUTA_DRIVER);
		 
		// Initialise browser
		 
		
		
		WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		// Load google.com
		 
		driver.get("http://www.google.com");
		 
		// close browser
		 
		driver.close();
	}
	
}
