package registered.rphtown.diabetes;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Index {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private WebDriver driver;
  TakesScreenshot scrShot;
  SeleniumTest test;


  @Before
  public void setUp() throws Exception {
	String driverPath = "C:\\\\Users\\a.batongbaca\\Documents\\Projects\\Selenium\\chromedriver_win32\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    test = new SeleniumTest();
  }

  @Test
  public void testIndex() throws Exception {
		test.setInitialUsername("epublishuser");
		test.setInitialPassword("epublishpassword");
		test.setUsername("mcijpdevtest@gmail.com");
		test.setPassword("Asdf1234");
		test.setURL("mci-jp-preview.epublishmerck.com/registered/rph_town/diabetes-mellitus/");
		test.setExpectedURL("https://mci-jp-preview.epublishmerck.com/registered/rph_town/diabetes-mellitus/");
		test.login(driver, test.getURL());
		do {
			Thread.sleep(1000);
		}while(isElementPresent(By.className("capture_btn capture_processing")));
		
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.urlToBe(test.getExpectedURL()));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		assertEquals(test.getExpectedURL(), driver.getCurrentUrl());
		this.takeScreenshot("C://Users/a.batongbaca/Documents/file.png");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
		this.takeScreenshot("C://Users/a.batongbaca/Documents/file2.png");
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
	    	e.printStackTrace();
	    }
	  }
}
