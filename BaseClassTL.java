package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTL 
{

	public ChromeDriver driver;
	public String fileName;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String url, String userName, String password) 
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		login(url, userName, password);

	}

	public void login(String url, String userName, String password) 
	{

		driver.get(url);
		// enter username
		driver.findElement(By.id("username")).sendKeys(userName);
		// enter password
		driver.findElement(By.id("password")).sendKeys(password);
		// click login
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@AfterMethod
	public void postCondition() 
	{
		
		driver.close();
		
	}
	
	@DataProvider(name="getData")
	public String[][] fetchData() throws IOException 
	{
		
		return ReadFromExcel.readFile(fileName);
		
	}

}