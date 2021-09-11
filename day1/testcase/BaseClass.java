package week5.day1.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ChromeDriver driver;
	
	@Parameters({"username","password","url"})
	@BeforeMethod
	public void login(String uname, String pwd, String url) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Locating the user name web element and type valid username
		driver.findElement(By.xpath("//input[@name = 'USERNAME']")).sendKeys(uname);

		// Locating the password and type valid password
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(pwd);

		// Locating the login button and click it
		driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();
		
		//Locating the CRM/SFA and  click it
		driver.findElement(By.xpath("//a[contains (text(),'/SFA') ]")).click();
		
		//Locate Leads Tab and click it
		driver.findElement(By.xpath("//a[text() = 'Leads']")).click();
	}

	@AfterMethod
	public void close() {
		
		driver.close();
	}
}
