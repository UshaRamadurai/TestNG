package week5.day1.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class MergeContacts extends BaseClass {

	@Test
	public void merge() throws InterruptedException {

		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		// Move the handle to newly opened window
		Set<String> winHandleSet = driver.getWindowHandles();
		List<String> winHandleList = new ArrayList<String>(winHandleSet);
		driver.switchTo().window(winHandleList.get(1));

		// Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		driver.switchTo().window(winHandleList.get(0));
		Thread.sleep(5000);

		// Click on Widget of To Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();

		Set<String> winHandleSet1 = driver.getWindowHandles();
		List<String> winHandleList1 = new ArrayList<String>(winHandleSet1);
		driver.switchTo().window(winHandleList1.get(1));

		Thread.sleep(3000);

		// Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();

		driver.switchTo().window(winHandleList1.get(0));

		// Click on Merge button
		driver.findElement(By.className("buttonDangerous")).click();

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Verify the title of the page
		String title = driver.getTitle();
		if (title.equals("View Contact | opentaps CRM"))
			System.out.println("Test pass!!Merge contact successful");
		else
			System.out.println("Test fail!! ");

	}

}
