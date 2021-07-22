package SampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleDemoTest 
{
	static WebDriver driver=null;
	
	@BeforeTest
	public void startBrowser() 
	{
		switch (" ") {
		case "chrome":
			
			System.out.println("---------------Browser Lanched---------------");
			System.setProperty("webdriver.chrome.driver","D:\\workspace\\Guru99Projects\\Drivers\\chromedriver(1).exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			
			break;

		case "firefox":
			
			System.out.println("---------------Browser Lanched---------------");
			System.setProperty("webdriver.gecko.driver","D:\\workspace\\Guru99Projects\\Drivers\\geckodriver.exe");
			driver =new FirefoxDriver();
			driver.manage().window().maximize();
			
			break;

		default:
			
			System.out.println("---------------Browser Lanched---------------");
			System.setProperty("webdriver.edge.driver","D:\\workspace\\Guru99Projects\\Drivers\\msedgedriver.exe");
			driver =new EdgeDriver();
			driver.manage().window().maximize();
			
			break;
		}
		
	}
	
	// Username and password is valid 
	
	@Test (priority = 1)
	public void testCas1() throws InterruptedException
	{
		System.out.println("---------------Website Launched---------------");
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//*[@name=\"uid\"]")).sendKeys("mngr342067");
		System.out.println("UserName:Valid");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("mapAbYj");
		System.out.println("Password:Valid");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(ActualTitle, ExpectedTitle);	
		Thread.sleep(2000);
	}
	
	// Invalid username and valid password
	
	@Test (priority = 2)
	public void testCase2() throws InterruptedException
	{
		System.out.println("---------------Website Launched---------------");
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//*[@name=\"uid\"]")).sendKeys("Gokul");
		System.out.println("UserName:Invalid");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("mapAbYj");
		System.out.println("Password:Valid");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(ActualTitle, ExpectedTitle);	
		Thread.sleep(2000);
	}
	
	// Valid username and Invalid password
	
	@Test (priority = 3)
	public void testCase3() throws InterruptedException
	{
		System.out.println("---------------Website Launched---------------");
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//*[@name=\"uid\"]")).sendKeys("mngr342067");
		System.out.println("UserName:Valid");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("12345");
		System.out.println("Password:Invalid");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(ActualTitle, ExpectedTitle);	
		Thread.sleep(2000);
	}
	
	// Invalid Username and Password
	
	@Test (priority = 4)
	public void testCase4() throws InterruptedException
	{
		System.out.println("---------------Website Launched---------------");
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//*[@name=\"uid\"]")).sendKeys("Gokul");
		System.out.println("UserName:Invalid");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("23455");
		System.out.println("Password:Invalid");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(ActualTitle, ExpectedTitle);	
		Thread.sleep(2000);
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.close();
		driver.quit();
		System.out.println("---------------Login Successfull---------------");
		System.out.println("Title Verified Successfully");
	}
}
