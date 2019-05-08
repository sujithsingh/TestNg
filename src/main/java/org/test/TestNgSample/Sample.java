package org.test.TestNgSample;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	public static WebDriver driver;
	public static WebDriverWait w;

	@BeforeClass
	private void launch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BRINDHA\\Desktop\\New folder\\TestNgSample\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println(d);

	}

	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@Parameters({"product"})
	@Test
	private void test(String pro) throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
//		w = new WebDriverWait(driver, 400);
//		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'_29YdH8')]"))).click();
		driver.findElement(By.xpath("//button[contains(@class,'_29YdH8')]")).click();
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys(pro);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[@class='col col-7-12']//div[contains(text(),'Apple iPhone 7')])[1]")).click();
		Thread.sleep(1500);
		String par = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for (String x : all) {
			if (!par.equals(x)) {
				driver.switchTo().window(x);
				
				Thread.sleep(1500);
				driver.findElement(By.xpath("(//button[contains(@class,'_2AkmmA _')])[1]")).click();
				String text = driver.findElement(By.xpath("(//div[contains(text(),'₹')])[2]")).getText();
				Thread.sleep(6000);
				System.out.println(text);
				Thread.sleep(6000);
			}
			

		}
		
	}
	
	@Test
	private void flipLaunch() {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[contains(@class,'_29YdH8')]")).click();
		driver.manage().window().maximize();

	}

	@AfterClass
	private void close() {
		driver.quit();
	}
}
