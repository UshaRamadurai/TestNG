package week5.day1.contacts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ChromeDriver driver;
	
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void loginContacts(String url, String uname, String pwd) {

		// Importing the setup files for browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get(url);

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();

	}
	
	@AfterMethod
	public void close() {
		// Close the window
			driver.close();
	}

}
