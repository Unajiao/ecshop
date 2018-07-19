package testmethod;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browser.Choosebrowser;
import browser.Openclosebrowser;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import data.Database;
import location.Search_location;

public class Search_for {
	@Test
	public void serch() {
		Openclosebrowser a =  new Openclosebrowser();
		try{
		WebDriver driver = a.openbrowser();
		Search_location s_l = new Search_location(driver);
		Map<String,String> map = new HashMap<String,String>();
		Database database = new Database();
		String sqlquery = "select  DISTINCT(goods_name) from  ecs_goods order by rand() limit 2;";
		List search_result = database.connect_Database(sqlquery);
		for(int i=0;i<search_result.size();i++) {
			map = (Map) search_result.get(i);
			String search_goods = (String) map.get("goods_name");
			s_l.search(search_goods);	
		}
		
		a.closebrowser();}
		catch(Exception e) {
			a.closebrowser();
			a.closebrowser();
			Choosebrowser.closeservice();
			assertEquals(e, "Ö±ÐÐ²éÑ¯");
			
		}
	}

}
