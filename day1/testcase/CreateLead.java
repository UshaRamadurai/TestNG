package week5.day1.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@Test(dataProvider = "sendData")
	public void runCreateLead(String fname,String lname, String company){
					
		driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();
		driver.findElement(By.xpath("(//input[@name ='companyName'])[2]")).sendKeys(company);
		driver.findElement(By.xpath("(//input[@name ='firstName'])[3]")).sendKeys(fname);
		driver.findElement(By.xpath("(//input[@name ='lastName'])[3]")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name ='submitButton' ]")).click();
		
		}
	
		@DataProvider
		public String[][] sendData() throws IOException{
			
			return ReadExcel.readData();
					
		}
		
		

}
