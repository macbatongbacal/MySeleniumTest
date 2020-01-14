package sampleAutomationFramework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MCIJapanRenewal {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String expectedUrl;
  TakesScreenshot scrShot;

  @Before
  public void setUp() throws Exception {
	String exePath = "C:\\\\Users\\a.batongbaca\\Documents\\Projects\\Selenium\\chromedriver_win32\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);
	expectedUrl = "https://mci-jp-preview.epublishmerck.com/registered/hcpsupport/top/edtl.xhtml";
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMCIJapanRenewal() throws Exception {
    driver.get("https://epublishuser:epublishpassword@mci-jp-preview.epublishmerck.com/hcpsupport/top/edtl.xhtml");
    driver.findElement(By.id("capture_signIn_signInEmailAddress")).sendKeys("mcijpdevtest@gmail.com");
    driver.findElement(By.id("capture_signIn_currentPassword")).sendKeys("Asdf1234");
    driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(3000);
	Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
	this.takeScreenshot("C:\\file.jpg");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  private void takeScreenshot(String fileWithPath) {
	    try {
			scrShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			// Move image file to new destination
			File DestFile = new File(fileWithPath);
			FileUtils.copyFile(SrcFile, DestFile);
	    } catch (IOException e) {
	    }
	  }
}
