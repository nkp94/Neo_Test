package pom_Neostox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Neo_Home {

	// Declaration
	@FindBy(xpath = "(//a[.='Sign In'])[1]")private WebElement sgnnn;
	@FindBy(xpath = "//input[@id='txt_mobilenumber']")private WebElement UI_1;
	@FindBy(xpath = "//button[@id='frmsubmit']")private WebElement SB_1;
	@FindBy(xpath = "//input[@id='accessPinModel_accsspin']")private WebElement PWD;
	@FindBy(xpath = "//button[@id='frmsubmit']")private WebElement SB2;
	@FindBy(xpath = "//span[@id='lbl_username']")private WebElement UserLink;
//	@FindBy(xpath= By.linkText("Logout")) private WebElement logout;
	@FindBy(xpath = "//span[.='Logout']")private WebElement logout;

		@FindBy(xpath="//a[.='Active Positions ']")private WebElement userID;		
		
		// Initialization
		public Neo_Home(WebDriver driver1){
			PageFactory.initElements(driver1,this);
		}
		
		// Utilization
	    public void pressSignIn_1() throws InterruptedException {
			sgnnn.click();	
			
		}
		
		public void enterID(String userID_1) {
			UI_1.sendKeys(userID_1);
			
		}

		public void clickSB1() {
			SB_1.click();
		}
		public void enterPass(String Password) {
			PWD.sendKeys(Password);
					
		}
		public void ClickSB2() {
			SB2.click();
		}

    	public String verifyuserID() {
			
			String actID = userID.getText();
			System.out.println("Verify user on main page : " +actID);
			return actID;		
		
		}
    	public void clickUserLink()  {
			UserLink.click();
			
		}
		
		public void clickLogout() {	
			logout.click();
			
		}
    	
		}	
