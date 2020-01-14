package sampleAutomationFramework;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exePath = "C:\\\\Users\\a.batongbaca\\Documents\\Projects\\Selenium\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();

		String username = "epublishuser";
		String password = "epublishpassword";
		String url = "https://" + username + ":" + password + "@mci-jp-preview.epublishmerck.com/hcpsupport/top/";
		String expectedUrl = "https://mci-jp-preview.epublishmerck.com/hcpsupport/top/";
		driver.get(url);
		
		// Print a Log In message to the screen
		System.out.println("Successfully opened the website mci-jp-preview.epublishmerck.com");
		try {
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("capture_signIn_signInEmailAddress")).sendKeys("mcijpdevtest@gmail.com");
			driver.findElement(By.id("capture_signIn_currentPassword")).sendKeys("Asdf1234");
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			Thread.sleep(5000);;
			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			System.out.println("Navigated to correct webpage : " + driver.getCurrentUrl());
		} catch (Throwable pageNavigationError) {
			System.out.println("Didn't navigate to correct webpage : " + driver.getCurrentUrl());
		}

		// Close the driver
		// driver.quit();
	}

}
