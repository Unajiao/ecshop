package location;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 登陆页面的页面元素定位
 * @author Administrator
 *
 */
public class Login_location {
	
	@FindBy(xpath="//font[@id='ECS_MEMBERZONE']/a[1]")
	private WebElement login_to;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="submit")
	private WebElement submit;
	
	@FindBy(xpath="//div[@class='box_1']/div/div/p[1]")
	private WebElement logion_result;
	
	public Login_location(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void login_action(String username1,String password1) {
		login_to.click();
		username.sendKeys(username1);
		password.sendKeys(password1);
		submit.click();
	}
	public void assert_login(String result) {
		assertEquals(logion_result.getText(),result);
	}
	public void assert_login_null(WebDriver driver,String result) {
		assertEquals(null_result(driver),result);
	}	
	public String null_result(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		String null_notice = alert.getText();
		return null_notice;		
	}
}
