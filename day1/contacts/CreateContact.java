package week5.day1.contacts;
//Goal : Code to create new Contact form

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day1.testcase.ReadExcel;

public class CreateContact extends BaseClass {

	@Test(dataProvider = "sendDatas")
	public void create(String fname, String lname, String dept, String desc, String email, String city, String note) {

		// Click Create contact
		driver.findElement(By.xpath("//a[text() = 'Create Contact']")).click();

		// Input First name and last name
		driver.findElement(By.id("firstNameField")).sendKeys(fname);
		driver.findElement(By.id("lastNameField")).sendKeys(lname);
		
		// Input Department, Description and email boxes
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(dept);
		driver.findElement(By.id("createContactForm_description")).sendKeys(desc);
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);

		// Select State/Province as NewYork
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateOption = new Select(state);
		stateOption.selectByVisibleText(city);

		// Click Create Contact
		driver.findElement(By.name("submitButton")).click();

		// Click Edit
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click();

		// Clear the Description box
		driver.findElement(By.id("updateContactForm_description")).clear();

		// Fill Important Note
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(note);

		// Click Update
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();

		// Verification
		String title = driver.getTitle();
		System.out.println("The Title of the current URL is :" + title);

	}

	@DataProvider
	public String[][] sendDatas() throws IOException{
		
		return ReadExcel.readDatas();
	}
}
