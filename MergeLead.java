package week6.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MergeLead extends BaseClassTL 
{

	public String parentWindow;

	@Test
	public void mergeLead() throws InterruptedException 
	{

		// click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		// click merge leads
		driver.findElement(By.linkText("Merge Leads")).click();
	
		// get parent window handle
		parentWindow = driver.getWindowHandle();

		// click from lead
		driver.findElement(By.xpath("//span[text()='From Lead']/ancestor::tr//img")).click();
		selectLead(1);

		// click to lead
		driver.findElement(By.xpath("//span[text()='To Lead']/ancestor::tr//img")).click();
		selectLead(2);

		// click merge
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		Thread.sleep(3000);
		System.out.println("Page Title : " + driver.getTitle());

	}

	public void selectLead(int i) throws InterruptedException 
	{

		switchWindow();
		// click leadId
		Thread.sleep(3000);
		
		WebElement eleLeadId = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[" + i + "]//a"));
		System.out.println(eleLeadId.getText());

		if (eleLeadId.isEnabled())
			eleLeadId.click();
		// switch to parentWindow
		driver.switchTo().window(parentWindow);
	
	}

	public void switchWindow() 
	{

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
	}

}