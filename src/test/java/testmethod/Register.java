package testmethod;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browser.Choosebrowser;
import browser.Openclosebrowser;
import location.Register_location;
@Test
/**
 * ע��ҳ��ע���µ��û����û���user+�����������123456
 * @author lenovo
 *
 */
public class Register {
	public void register_new() {
		Openclosebrowser a =  new Openclosebrowser();
		WebDriver driver = a.openbrowser();
		try {
			Register_location rl = new Register_location(driver);
			rl.Register_keys();
			rl.assert_register();	
			a.closebrowser();
			Choosebrowser.closeservice();
		}
		catch(Exception e) {
			a.closebrowser();
			Choosebrowser.closeservice();
			assertEquals(e, "ע��ɹ�");
		}
	}
}
