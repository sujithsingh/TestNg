package org.test.TestNgSample;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipCart {
	static WebDriver driver;
	@Parameters({"browserName"})
	@BeforeClass
	private void launch(String brwName) {
		if (brwName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\BRINDHA\\Desktop\\New folder\\TestNgSample\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if (brwName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\BRINDHA\\Desktop\\New folder\\TestNgSample\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}

	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println(d);

	}
	@AfterClass
	private void close() {
		driver.quit();
	}

	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	private void test() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
//		w = new WebDriverWait(driver, 400);
//		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'_29YdH8')]"))).click();
		driver.findElement(By.xpath("//button[contains(@class,'_29YdH8')]")).click();
		driver.manage().window().maximize();
	}
	@Test
	private void sysout() {
		System.out.println("mei");
	}

}
