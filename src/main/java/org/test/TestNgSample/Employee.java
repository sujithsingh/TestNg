package org.test.TestNgSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Employee {
	static WebDriver driver;
	@Test(dataProvider = "res")
	private void test1(String s1, String s2) {
		System.out.println(s1);
		System.out.println(s2);

	}

	@DataProvider(name = "res")
	public Object[][] data() {

		return new Object[][] { { "10", "Java" }, { "20", "Sql" } };
	}
	@Test(dataProvider="res")
	public void test(String s1, String s2) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BRINDHA\\Desktop\\New folder\\TestNgSample\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(s1);
		driver.findElement(By.id("pass")).sendKeys(s2);
		
	}
//	@DataProvider(name="res")
//	public Object[][] data1() {
//
//		return new Object[][] { { "10", "Java" }, { "20", "Sql" },{"30","selenium"} };
//	}
//	@DataProvider(name="res", parallel=true)
//	public Object[][] data2() {
//
//	}

}
