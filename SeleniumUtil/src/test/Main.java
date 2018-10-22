package test;

import org.openqa.selenium.By;

import util.TestChrome;
import util.TestIE;
import util.TestUtil;

public class Main {

	public static void main(String[] args) {
		
		TestUtil u = new TestUtil(new TestChrome());
		
		u.getBrowser().propertyMaximized();
		u.getBrowser().open();
		
		u.get("http://newtours.demoaut.com/");
		u.sendKeys(By.name("userName"), "asd");
		u.sendKeys(By.name("password"), "asd");
		u.click(By.name("login"));
		
		u.getBrowser().close();
	}
	
}
