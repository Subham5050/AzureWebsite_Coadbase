package testcase_Azure;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Selenium_1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.navigate().to("http://jt-dev.azurewebsites.net/#/SignUp");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Actions ac = new Actions(driver);
		WebElement tr = driver.findElement(By.xpath("//*[@id='language']"));
		ac.click(tr).build().perform();
		
		
		List<WebElement> ts = driver.findElements(By.xpath("//div[@class='ng-binding ng-scope']"));
		
		if(ts.equals("English"))
		{
			System.out.println("English is present");
		}
		else if(ts.equals("Dutch"))
		{
			System.out.println("Dutch is present");
		}
		else {
			System.out.println("Both English and Dutch are not present");
		}
		
		driver.findElement(By.id("name")).sendKeys("Subham");
		driver.findElement(By.id("orgName")).sendKeys("Subham");
		driver.findElement(By.xpath("//input[@id='singUpEmail']")).sendKeys("testautoodididi@yopmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='black-color ng-binding']/parent::label")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Get Started')]")).click();
		Thread.sleep(5000);
		WebElement validateemail = driver.findElement(By.xpath("//*[@class='ng-binding']/parent::div/parent::form/child::div"));
		String validmes = validateemail.getText();
		System.out.println(validmes);
		String ms = "A welcome email has been sent. Please check your email.";
		if(validmes.equalsIgnoreCase(ms))
		{
			System.out.println("Test Case passes");
		}
		else
		{
			System.out.println("Test Case failed");
		}
		
	
		
		//Assert.assertEquals(validateemail.getText(),  " A welcome email has been sent. Please check your email. ");
		
		
		
		
		
		
		

	}

}
