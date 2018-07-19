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
	 * ѡ����Ҫ�������������ֻ������chrome����firefox
	 * @param browser����������ƣ�����Ϊchrome����firefox
	 * @return driver����������Ϊdriver
	 */
	public static DriverService service;
	public static WebDriver chooseservice(String browser) {
		//Map<DriverService,WebDriver> myMap = new HashMap<DriverService,WebDriver>();
		WebDriver driver = null;
		//��ʾ�ȴ�10s
		if(browser!=null) {
			//��Ҫ����chrome�����
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
			}//��Ҫ����firefox�����
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
//				//firefox���ǰ�װ��Ĭ��·����������Ҫָ��firefox�İ�װ·��
//				System.setProperty("webdriver.firefox.bin","F:\\firefox\\path\\firefox.exe");
//				driver = new FirefoxDriver();
				}	
			if(browser.contains("ie")) {
				System.out.println("��ʱû��IE");
			}
			return driver;  
		}
		else
			System.out.println("ѡ������������ȷ");
		    return driver; 
	}
@AfterSuite
	public static void closeservice() {
		if(service != null) {
			service.stop();
		}
	}
}
