package util;


import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class TestIE extends TestBrowser{

public static final String RUTA_DRIVER = "src/res/IEDriverServer.exe";
	
	private final InternetExplorerOptions ieOptions = new InternetExplorerOptions();
	
	private boolean maximized;
	
	public void open(){
		System.setProperty("webdriver.ie.driver",RUTA_DRIVER);
		setDriver(new InternetExplorerDriver(ieOptions));
		if (maximized) {
			getDriver().manage().window().maximize();
		}
	}
	
	public void propertyPrivateMode(){
		ieOptions.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		ieOptions.addCommandSwitches("-private");
	}
	
	public void propertyMaximized(){
		if(getDriver()!=null){
			getDriver().manage().window().maximize();
		}
		maximized = true;
	}
	
}
