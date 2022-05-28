package com.ecommerce;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TvPurchase {
	static  WebDriver driver ;


	@BeforeClass
	public static void   beforeClass() {
		System.out.println("Before class");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\FlipkartJunit\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
	}
@AfterClass
	public static  void afterClass() throws InterruptedException {
	System.out.println("After Class");
	Thread.sleep(3000);
	 driver.quit();
}
static long startime;
@Before
public void beforeTest() {
	System.out.println("Before test");
	long starttime=System.currentTimeMillis();
}
	@After
	public void afterTest()  {
		System.out.println("After test");
long endtime=System.currentTimeMillis();
System.out.println(endtime-startime);
	}
	@Test
	public void m1() {
		WebElement clsbtn= driver.findElement(By.xpath("//button[text()='✕']"));
		clsbtn.click();
	}
	
	@Test
	public void m2(){
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("lg tv");	
		
	}
	static String name;
	@Test
	public void m3() throws IOException {
	
		WebElement searchclk=driver.findElement(By.xpath("//button[@type='submit']"));
		searchclk.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		WebElement excelname=driver.findElement(By.xpath("//div[text()='LG 80 cm (32 inch) HD Ready LED Smart TV']"));
String name=excelname.getText();
		System.out.println(name);
	}
	
	
@Test
public void m4() throws IOException {
	TakesScreenshot t=(TakesScreenshot)driver;
	File source=t.getScreenshotAs(OutputType.FILE);
	File target=new File("C:\\Users\\Admin\\eclipse-workspace\\FlipkartJunit\\Scrrenshot.png");
	FileUtils.copyFile(source, target);
	WebElement down=driver.findElement(By.xpath("//div[text()='Highlights']"));
	JavascriptExecutor j=(JavascriptExecutor)driver;
	j.executeScript("arguments[0].scrollIntoView(true)",down);
	File source1=t.getScreenshotAs(OutputType.FILE);
	File target1=new File("C:\\Users\\Admin\\eclipse-workspace\\FlipkartJunit\\Scrrenshot.png");
	FileUtils.copyFile(source1, target1);
}

}
