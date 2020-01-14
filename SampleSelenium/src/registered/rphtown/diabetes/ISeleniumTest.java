package registered.rphtown.diabetes;

import org.openqa.selenium.WebDriver;

public interface ISeleniumTest {
	
	public void login(WebDriver myDriver, String url);
	public void testMsdLogin(WebDriver myDriver) ;
	
}
