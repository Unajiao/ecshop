package location;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 查询操作页面定位元素
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
	//使用数据库拿出来的seach_for，在页面执行查询，比较seach_for和查询结果是否一致
	public void search(String seach_for) {
		search_input.sendKeys(seach_for);
		search_btn.click();	
		//s表示查询结果
		String s = serch_result.getText();
		assertEquals(s, seach_for);
	}
}
