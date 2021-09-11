package week5.day1.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{

	@Parameters({"phoneNo"})
	@Test
	public void runDeleteLead(String phNumber) throws InterruptedException {
		
		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Phone
		driver.findElement(By.linkText("Phone")).click();

		//Input phone number
		driver.findElement(By.name("phoneNumber")).sendKeys(phNumber);

		// Click Find Leads
		WebElement findLeads = driver.findElement(By.xpath("//button[text() = 'Find Leads']"));
		findLeads.click();

		Thread.sleep(3000);

		// Capture Leadid of first result and click it
		WebElement searchLink = driver
				.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a"));
		String leadId = searchLink.getText();
		System.out.println("The leadId is :" + leadId);
		searchLink.click();

		// Delete the Leadid
		driver.findElement(By.className("subMenuButtonDangerous")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Search for captured id
		driver.findElement(By.name("id")).sendKeys(leadId);

		// Click Find Lead
		driver.findElement(By.xpath("//button[text() ='Find Leads']")).click();

		// Verification of delete
		boolean displayed = driver.findElement(By.xpath("//div[text() = 'No records to display']")).isDisplayed();
		if (displayed)
			System.out.println("TEst pass!! Delete lead successful");
		else
			System.out.println("TEst fail");
		

	}

}
