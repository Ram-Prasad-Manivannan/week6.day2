package week6.day2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClassTL 
{

	@Test
	public void duplicateLead() throws InterruptedException 
	{

		// click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		// click find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		// Click on Email xpath
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		// Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("b");
		
		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		// Capture name of First Resulting lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
		String leadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		// Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(3000);
		
		// Verify the title as 'Duplicate Lead'
		String titleText = driver.getTitle();

		verifyTitle(titleText);

		// Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(3000);

		// Confirm the duplicated lead name is same as captured name
		String dupLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		verifyDuplicateLeadName(leadName, dupLeadName);
	
	}

	private void verifyDuplicateLeadName(String leadName, String dupLeadName) 
	{
	
		if (leadName.equals(dupLeadName))
			System.out.println("Duplicated lead name is same as captured name");
	
	}

	private void verifyTitle(String titleText) 
	{
	
		if (titleText.contains("Duplicate Lead"))
			System.out.println("Title verified as : " + titleText);

	}

}