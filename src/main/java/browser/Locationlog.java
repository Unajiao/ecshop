package browser;


import java.net.URL;
import java.util.NoSuchElementException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Locationlog extends RemoteWebDriver{
	private org.apache.logging.log4j.Logger logger;
	public Locationlog(URL url,Capabilities Capabilities,Class<?> clazz) {
		super(url,Capabilities);
		logger = org.apache.logging.log4j.LogManager.getLogger(clazz);	
	}
	@Override
	public WebElement findElementByName(String using) {
		// TODO Auto-generated method stub
		try {
			WebElement webelement = super.findElementByName(using); 
			logger.info(using + "成功定位");
			return webelement;
		}
		catch(NoSuchElementException e){
			logger.info(using +"不能找到");
			return null;	
			}
		}
	@Override
	public WebElement findElementByXPath(String using) {
		// TODO Auto-generated method stub
		try {
			WebElement webelement = super.findElementByXPath(using); 
			logger.info(using + "成功定位");
			return webelement;
		}
		catch(NoSuchElementException e) {
			logger.info(using +"不能找到");
			return null;
		}
	}
	@Override
	public WebElement findElementByLinkText(String using) {
		// TODO Auto-generated method stub
		try {
			WebElement webelement = super.findElementByLinkText(using); 
			logger.info(using + "成功定位");
			return webelement;
		}
		catch(NoSuchElementException e) {
			logger.info(using +"不能找到");
			return null;
			}
	}
	@Override
	public WebElement findElementByPartialLinkText(String using) {
		// TODO Auto-generated method stub
		try {
			WebElement webelement = super.findElementByPartialLinkText(using); 
			logger.info(using + "成功定位");
			return webelement;
		}
		catch(NoSuchElementException e) {
			logger.info(using +"不能找到");
			return null;
			}
	}
	@Override
	public WebElement findElementById(String using) {
		// TODO Auto-generated method stub
		try {
			WebElement webelement = super.findElementById(using); 
			logger.info(using + "成功定位");
			return webelement;
		}
		catch(NoSuchElementException e) {
			logger.info(using +"不能找到");
			return null;
			}
	}
}
