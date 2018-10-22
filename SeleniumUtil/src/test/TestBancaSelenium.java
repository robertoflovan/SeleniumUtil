package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBancaSelenium {

WebDriver driver ;
	
	public TestBancaSelenium(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RF43496\\Documents\\Roberto Flores\\lib\\Selenium\\Driver\\chromedriver.exe");	  
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBancaSelenium u = new TestBancaSelenium();
		u.cargarBrowser();
		
	

	

	}

	public  WebDriver  cargarBrowser () {
		WebElement elemento ;
		

		
			 // abrir navegador 
		driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
		
		
			try {
				//Thread.sleep(2000);
				driver.findElement(By.id("splash-207555-close-button")).click();
				driver.findElement(By.name("username1")).sendKeys("111572424");;
				driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
				driver.findElement(By.id("textFirma")).sendKeys("a1b2c3d4");
				driver.findElement(By.id("enterId")).click();
				driver.findElement(By.id("link_lkTransfers")).click();
				
				
				
				// ComboBoxx captura de de pantalla  Cuenta de Origen 
				driver.findElement(By.id("sourceInstanceID-button")).click();				
				driver.findElement(By.xpath("//*[@id='sourceInstanceID-menu']/li[2]/span")).click();
				scrollUniversal ();			
				//takeScreenShotTest(driver, "Imagen");
				driver.findElement(By.id("sourceInstanceID-menu-option-2")).click();							
				//Thread.sleep(3000);
					
				// ComboBoxx captura de de pantalla  Cuenta Destino
				driver.findElement(By.id("destinationInstanceID-button")).click();				
				driver.findElement(By.xpath("//*[@id='destinationInstanceID-menu']/li[2]/span")).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id='destinationInstanceID-menu-option-1']/span")).click();	
				takeScreenShotTest(driver, "Imagen");
				//Thread.sleep(6000);
				
				// clic en el boton continuar 
				driver.findElement(By.id("cN-primaryNavEnabled")).click();
				//Thread.sleep(2000);
				// monto 
				driver.findElement(By.id("Debit-withtext")).sendKeys("75");;
				//Thread.sleep(2000);
				scrollUniversal();
				driver.findElement(By.id("InternalTransfer_NextLink_Enabled")).click();					
				//Thread.sleep(4000);
				scrollUniversal();
				takeScreenShotTest(driver, "TXN");
				//Thread.sleep(4000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			} finally {
				
				takeScreenShotTest(driver, "Error");
				driver.findElement(By.id("link_logout")).click();
				driver.quit();
			}
			
			
			
			//driver.quit();
			
		
		return driver;
		}
	
	
	public  void takeScreenShotTest(WebDriver driver, String imageName) {
	      //Directorio donde quedaran las imagenes guardadas
	      File directory = new File("C:\\Users\\RF43496\\Documents\\Roberto Flores\\Selenium aux\\img");
	 
	      try {
	         if (directory.isDirectory()) {
	            //Toma la captura de imagen
	            File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            //Mueve el archivo a la carga especificada con el respectivo nombre
	            FileUtils.copyFile(imagen, new File(directory.getAbsolutePath()   + "\\" + imageName + ".png"));
	         } else {
	            //Se lanza la excepcion cuando no encuentre el directorio
	            throw new IOException("ERROR : La ruta especificada no es un directorio!");
	         }
	      } catch (IOException e) {
	         //Impresion de Excepciones
	         e.printStackTrace();
	      }
	   }
		

	public  void scrollUniversal (){
				
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		
	}
	
}
