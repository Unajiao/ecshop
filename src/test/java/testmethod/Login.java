package testmethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import browser.Choosebrowser;
import browser.Openclosebrowser;
import location.Login_location;


public class Login {
	@DataProvider(name="user_data_provider")
	public Object[][] user_data(){
		return new Object[][] {
			{"����","123456","��¼�ɹ�"},
			{"����","123","�û������������"},
			{"����","","- ��¼���벻��Ϊ�ա�"},
			{"","124","- �û�������Ϊ�ա�" }		
		};
		
	}
	@Test(dataProvider="user_data_provider")
	public void login_new(String username,String password,String result) {
		Openclosebrowser a =  new Openclosebrowser();
		WebDriver driver = a.openbrowser();
		try {
		Login_location r2 = new Login_location(driver);
		r2.login_action(username,password);
		if(username.equals("")||password.equals("")) {
			r2.assert_login_null(driver,r2.null_result(driver));
			driver.switchTo().alert().accept();
		}else {
			r2.assert_login(result);
		}
		a.closebrowser();
		Choosebrowser.closeservice();
		}
		catch(Exception e) {
			a.closebrowser();
			Choosebrowser.closeservice();	
			assertEquals(e, "ֱ�е�¼");
		}
	}
}
