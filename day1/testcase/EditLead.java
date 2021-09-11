package week5.day1.testcase;
//Goal : Code to edit a record

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {

	@Test(dataProvider = "sendData")
	public void runEditLead(String fname, String comName) throws InterruptedException {

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter First name
		driver.findElement(By.xpath("(//input[@name ='firstName'])[3]")).sendKeys(fname);

		// Click Find Leads
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(3000);

		// Click on the First resulting lead
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')])[1]/a")).click();

		// verification of Duplicate Lead page
		if (driver.getTitle().equals("Find Leads | opentaps CRM"))
			System.out.println("In Find Leads page");

		// Click Edit
		driver.findElement(By.xpath("//a[contains (@href, 'updateLeadForm?partyId')]")).click();

		// Edit Company name
		WebElement coName = driver.findElement(By.id("updateLeadForm_companyName"));
		coName.clear();
		coName.sendKeys(comName);

		// Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Verification of update
		boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'Company')]")).isDisplayed();
		if (displayed)
			System.out.println("TEst pass!! Updation successful");
		else
			System.out.println("TEst fail");

	}

	@DataProvider
	public String[][] sendData() {

		String[][] data = new String[2][2];

		data[0][0] = "test";
		data[0][1] = "New Company";

		data[1][0] = "Usha";
		data[1][1] = "SatUsha Company";

		return data;

	}

}
