package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_Neostox.JsonDataFetch;
import pom_Neostox.Neo_Home;


@Test
public class Test_Class {
	FileInputStream fis2;
	Sheet sh2;
	WebDriver driver1;
	Neo_Home hme;
   JsonDataFetch js=new JsonDataFetch();
	@BeforeClass
	public void InitialzeBrowser1() throws Throwable {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\chrome driver\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
		driver1 = new ChromeDriver(opt);

		driver1.get("https:/neostox.com/");
		String title = driver1.getTitle();
		System.out.println("Page title is :" + title);
		driver1.manage().window().maximize();
//		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void LoginToApp() throws Throwable {

		hme = new Neo_Home(driver1);
		hme.pressSignIn_1();
		Thread.sleep(4000);
		fis2 = new FileInputStream("D:\\neostox.xlsx");
		sh2 = WorkbookFactory.create(fis2).getSheet("Sheet1");
		//String userID_1 = sh2.getRow(0).getCell(0).getStringCellValue();
		String userID_1=js.getJsonData("UserID");
		hme.enterID(userID_1);
		Thread.sleep(2000);
		hme.clickSB1();
		Thread.sleep(2000);
		//String Password = sh2.getRow(0).getCell(1).getStringCellValue();
		String Password=js.getJsonData("password");
		hme.enterPass(Password);
		hme.ClickSB2();
//		fis2.close();
	}
	@Test
	public void verifyuserID() throws Throwable {
		Reporter.log("running verify user id", true);
		String actID = hme.verifyuserID();
		String ExpT=js.getJsonData("ExpT");
//		String ExpT = sh2.getRow(0).getCell(2).getStringCellValue();
		AssertJUnit.assertEquals(ExpT, actID);

	}

	@AfterMethod
	public void logoutApp() {
		hme.clickUserLink();
		hme.clickLogout();
		Reporter.log("logout the application", true);
	}

	@AfterClass
	public void closeBrowser() {
		driver1.quit();
		Reporter.log("close the app", true);
	}

}

//windowhelper.swithchToWindowByName(title);
//WebDriverWait wait1 = new WebDriverWait(driver1, 10);
//WebElement element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[.='Sign In'])[1]")));

