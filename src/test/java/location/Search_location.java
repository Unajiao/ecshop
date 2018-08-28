package location;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * ��ѯ����ҳ�涨λԪ��
 * @author Administrator
 *
 */
public class Search_location {
	@FindBy(name="keywords")
	private WebElement search_input;
	
	@FindBy(name="imageField")
	private WebElement search_btn;

	@FindBy(xpath="div[@class='goodsItem']/p/a")
	private WebElement serch_result;
	
	public Search_location(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//ʹ�����ݿ��ó�����seach_for����ҳ��ִ�в�ѯ���Ƚ�seach_for�Ͳ�ѯ����Ƿ�һ��
	public void search(String seach_for) {
		search_input.sendKeys(seach_for);
		search_btn.click();	
		//s��ʾ��ѯ���
		String s = serch_result.getText();
		assertEquals(s, seach_for);
	}
}
