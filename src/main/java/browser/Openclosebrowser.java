package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Openclosebrowser {
private  WebDriver driver;
	public WebDriver openbrowser() {
		driver = Choosebrowser.chooseservice("chrome");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://localhost/ecshop/");
		return driver;
	}
@AfterClass
	public void closebrowser() {
		driver.quit();
	}
}
