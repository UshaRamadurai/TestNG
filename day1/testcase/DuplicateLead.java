package week5.day1.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{

	@Parameters({"email"})
	@Test
	public  void runDuplicateLead(String mail) throws InterruptedException {

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click Email tab
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();

		// Input email id
		driver.findElement(By.name("emailAddress")).sendKeys(mail);

		// Click Find Leads
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		Thread.sleep(3000);
		// Capture and Click first resulting lead name
		WebElement firstLead = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String firstText = firstLead.getText();
		firstLead.click();

		// Click Duplicate Lead tab
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra'])[2]/a[text() = 'Duplicate Lead']")).click();

		// verification of Duplicate Lead page
		if (driver.getTitle().equals("Duplicate Lead | opentaps CRM"))
			System.out.println("In Duplicate Lead page");

		// Click Create Lead
		driver.findElement(By.name("submitButton")).click();

		//Capture the duplicated name
		String dupText = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		//Verification of duplicated one
		if (firstText.equals(dupText))
			System.out.println("Test Pass !! Duplicate created");
		else
			System.out.println("Test Fail !! Duplicate not created");

		}

}
