package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Facebook_Login {
	
	public static void main(String [] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		WebElement emil = driver.findElement(By.xpath("//input[@type='text']"));
		emil.sendKeys("nileshpatil");
		WebElement pass = driver.findElement(By.xpath("//input[@name='pass']"));
		pass.sendKeys("123456");
		
		WebElement btn = driver.findElement(By.xpath("//button[text()='Log in']"));
		btn.click();
		
	}

}
