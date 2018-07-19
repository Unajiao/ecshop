package location;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * register頁面
 * @author lenovo
 *
 */
public class Register_location {
	//记录随机产生的id号
	public static int user_id;
	
	@FindBy(linkText="免费注册")
	private WebElement Register_to;
	
	@FindBy(partialLinkText="登陆")
	public WebElement login_to;
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password1")
	public WebElement password1;
	
	@FindBy(id="conform_password")
	public WebElement conform_password;
	
	@FindBy(name="extend_field5")
	public WebElement tele_no;
	
	@FindBy(name="Submit")
	public WebElement submit;
	
	@FindBy(xpath="//div[@class='box_1']/div/div/p[1]")
	private WebElement result_register;	
	
	public Register_location(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void Register_keys() {
		Register_to.click();
		Random random= new Random();
		user_id=random.nextInt(1000);
		username.sendKeys("user"+user_id);
		email.sendKeys(user_id+"@qq.com");
		password1.sendKeys("123456");
		conform_password.sendKeys("123456");
		tele_no.sendKeys("12345678911");
		submit.click();		
	}
	public void assert_register() {
		assertEquals(result_register.getText(), "用户名 user"+user_id+" 注册成功");
	}

}
