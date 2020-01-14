package registered.rphtown.diabetes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest implements ISeleniumTest{

	private String INITIAL_USERNAME;
	private String INITIAL_PASSWORD;
	private String USERNAME;
	private String PASSWORD;
	private String URL;
	private String EXPECTED_URL;
	WebDriverWait wait;

	  public String getInitialUsername() {
		return INITIAL_USERNAME;		  
	  };

	  public void setInitialUsername(String initialUsername) {
		this.INITIAL_USERNAME = initialUsername;		  
	  };

	  public String getInitialPassword() {
		return INITIAL_PASSWORD;		  
	  };

	  public void setInitialPassword(String initialPassword) {
		this.INITIAL_PASSWORD = initialPassword;		  
	  };
	  
	  public String getUsername() {
		return USERNAME;		  
	  };

	  public void setUsername(String username) {
		this.USERNAME = username;		  
	  };

	  public String getPassword() {
		return PASSWORD;		  
	  };

	  public void setPassword(String password) {
		this.PASSWORD = password;		  
	  };
	  
	  public String getURL() {
		return URL;		  
	  };

	  public void setURL(String url) {
		this.URL = url;		  
	  };
	  
	  public String getExpectedURL() {
		return EXPECTED_URL;		  
	  };

	  public void setExpectedURL(String expectedUrl) {
		this.EXPECTED_URL = expectedUrl;		  
	  };
	  
	public void login(WebDriver myDriver, String url){
 		String URL = "https://" + getInitialUsername() 
			  + ":" 
			  + getInitialPassword() 
			  + "@" + getURL();
 		myDriver.manage().window().maximize();
 		myDriver.get(URL);
 		// wait for the page to load
 		wait = new WebDriverWait(myDriver, 6000);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_signIn_signInEmailAddress")));
 		testMsdLogin(myDriver);
	}
	
	public void testMsdLogin(WebDriver myDriver) {
 		// get the web elements
 		WebElement msd_username = myDriver.findElement(By.id("capture_signIn_signInEmailAddress"));
 		WebElement msd_password = myDriver.findElement(By.id("capture_signIn_currentPassword"));
 		WebElement msd_login_btn = myDriver.findElement(By.className("capture_secondary"));
 		
 		// add inputs to the fields
 		msd_username.sendKeys(getUsername());
 		msd_password.sendKeys(getPassword());
 		msd_login_btn.click();
 	}
}
