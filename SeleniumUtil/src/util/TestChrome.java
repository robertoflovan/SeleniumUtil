package util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestChrome extends TestBrowser{

	public static final String RUTA_DRIVER = "src/res/chromedriver.exe";
	
	private final ChromeOptions chromeOptions = new ChromeOptions();
	
	public void open(){
		System.setProperty("webdriver.chrome.driver", RUTA_DRIVER);
		setDriver(new ChromeDriver(chromeOptions));
	}
	
	public void propertyPrivateMode(){
		chromeOptions.addArguments("incognito");
	}
	
	public void propertyMaximized(){
		chromeOptions.addArguments("--start-maximized");
	}



	
}
