package browser;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterSuite;


public class Choosebrowser {
	/**
	 * 选择需要的浏览器，限制只能输入chrome或者firefox
	 * @param browser：浏览器名称，可以为chrome或者firefox
	 * @return driver：返回类型为driver
	 */
	public static DriverService service;
	public static WebDriver chooseservice(String browser) {
		//Map<DriverService,WebDriver> myMap = new HashMap<DriverService,WebDriver>();
		WebDriver driver = null;
		//隐示等待10s
		if(browser!=null) {
			//需要的是chrome浏览器
			if(browser.equalsIgnoreCase("chrome")) {
				  service= new ChromeDriverService.Builder()
		   		 .usingDriverExecutable(new File("driver/chromedriver.exe"))
					 .usingAnyFreePort()
					 .build();
			   	 try {
			   		    service.start();
			   		} catch (IOException e) {
			   			e.printStackTrace();
			   		}
			   	URL url = service.getUrl();
			   	driver =new Locationlog(url, DesiredCapabilities.chrome(),Thread.currentThread().getClass());
			   //	myMap.put(service,driver);
			}//需要的是firefox浏览器
			if(browser.equalsIgnoreCase("firefox")) {
				service= new GeckoDriverService.Builder()
				   		 .usingDriverExecutable(new File("driver/geckodriver.exe"))
							 .usingAnyFreePort()
							 .build();
			   	 try {
			   		    service.start();
			   		} catch (IOException e) {
			   			e.printStackTrace();
			   		}
			   	URL url = service.getUrl();
			   	driver =new Locationlog(url, DesiredCapabilities.firefox(), Thread.currentThread().getClass());
				//myMap.put(service,driver);
//				System.setProperty("webdriver.gecko.driver","F:\\eclipse\\geckodriver.exe");
//				//firefox不是安装在默认路径，所以需要指出firefox的安装路径
//				System.setProperty("webdriver.firefox.bin","F:\\firefox\\path\\firefox.exe");
//				driver = new FirefoxDriver();
				}	
			if(browser.contains("ie")) {
				System.out.println("暂时没有IE");
			}
			return driver;  
		}
		else
			System.out.println("选择的浏览器不正确");
		    return driver; 
	}
@AfterSuite
	public static void closeservice() {
		if(service != null) {
			service.stop();
		}
	}
}
