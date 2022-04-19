package org.base;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.server.handler.GetAllWindowHandles;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
public static WebDriver launchBrowser(String browsername) {
//	WebDriverManager.chromedriver().setup();
//    driver = new ChromeDriver();
	if(browsername.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
	}
	else if (browsername.equals("edge")) {
		WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
	}
	else if (browsername.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
	}
	return driver;
//	switch(browserName) {
//	
//	case "chrome":
//	WebDriverManager.chromedriver().setup();
//  driver = new ChromeDriver();
//	break;
//	case "edge":
//		WebDriverManager.edgedriver().setup();
//	  driver = new EdgeDriver();
//		break;
//	case "firefox":
//		WebDriverManager.firefoxdriver().setup();
//	  driver = new FirefoxDriver();
//		break;
	}
//	return driver;


public static void launchUrl(String url) {
	driver.get(url);
driver.manage().window().maximize();
}
public static void implicityWait(long time) {
driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

}
public static void currentUrl() {
	String currentUrl = driver.getCurrentUrl();

}
public static String getTitle() {
	String title = driver.getTitle();
	return title;

}
public static void quit() {
	driver.quit();

}
public static void sendKeys(WebElement e,String value) {
e.sendKeys(value);

}
public static void click(WebElement e) {
	e.click();
}


public static WebElement findElement(String locatorName, String locatorValue) {
	
	WebElement value = null;
	if(locatorName.equals("id")) {
 value = driver.findElement(By.id(locatorValue));
}
	if(locatorName.equals("name")) {
	value = driver.findElement(By.name(locatorValue));
	}
		if(locatorName.equals("xpath")) {
	 value = driver.findElement(By.xpath(locatorValue));

		}
		
		return value;
}


//switch(locatorName) {
//case"id":
//	value = driver.findElement(By.id(locatorValue));
//
//break;
public static String getText(WebElement e) {
 String text = e.getText();
return text;
 
}
public static String getAttribute(WebElement e) {
String text = e.getAttribute("value");
return text;
}
public static void moveToElement(WebElement e) {
	Actions a = new Actions(driver);
a.moveToElement(e).perform();
}
public static void DragAndDrop(WebElement src, WebElement des){
	Actions a = new Actions(driver);
a.dragAndDrop(src, des).perform();
}
public static void contextClick(WebElement e) {
	Actions a = new Actions(driver);
a.contextClick(e).perform();
}
public static void DoubleClick(WebElement e) {
	Actions a = new Actions(driver);
a.doubleClick(e).perform();
}
public static void Click(WebElement e) {
	Actions a = new Actions(driver);
a.click(e).perform();
}
public static void ClickAndHold(WebElement e) {
	Actions a = new Actions(driver);
a.clickAndHold(e).perform();
}

public static void Release(WebElement e) {
	Actions a = new Actions(driver);
a.release(e).perform();
}

public static void Clear(WebElement e) {
e.clear();
}
public static void accept() {
Alert alertname = driver.switchTo().alert();
alertname.accept();
}
public static void dismiss() {
Alert alertname = driver.switchTo().alert();
alertname.dismiss();
}
public static String getText() {
Alert alertname = driver.switchTo().alert();
String text = alertname.getText();
return text;
}
public static void selectByValue(WebElement e, String value) {
	Select s = new Select(e);
s.selectByValue(value);
}
public static void selectByIndex(WebElement e, int index) {
	Select s = new Select(e);
s.selectByIndex(index);
}
public static void selectByVisibleText(WebElement e, String text) {
	Select s = new Select(e);
s.selectByVisibleText(text);
}
public static List<WebElement> getOptions(WebElement e) {
	Select s = new Select(e);
List<WebElement> options = s.getOptions();
return options;
}
public static List<WebElement> getAllSelectedOptions(WebElement e) {
	Select s = new Select(e);
List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
return allSelectedOptions;
}
public static WebElement getFirstSelectedOption(WebElement e) {
	Select s = new Select(e);
WebElement firstSelectedOption = s.getFirstSelectedOption();
return firstSelectedOption;
}
public static boolean isMultiple(WebElement e) {
	Select s = new Select(e);
boolean multiple = s.isMultiple();
return multiple ;
}
public static void deselectByValue(WebElement e, String value) {
	Select s = new Select(e);
s.deselectByValue(value);
}
public static void deselectByIndex(WebElement e, int index) {
	Select s = new Select(e);
s.deselectByIndex(index);
}
public static void deselectByVisibleText(WebElement e, String text) {
	Select s = new Select(e);
s.deselectByVisibleText(text);
}
public static void deselectAll(WebElement e) {
	Select s = new Select(e);
s.deselectAll();
}
public static void getScreenShot(String name) throws IOException {
	TakesScreenshot tk =(TakesScreenshot)driver;
	File src = tk.getScreenshotAs( OutputType.FILE);
	File des = new File("C:\\Users\\mix\\eclipse-workspace\\MavenProject\\src\\test\\resources"+name+".png");
	FileUtils.copyFile(src, des);
}
//java script
//getAttributevalue
public static String getAttributevalue(WebElement e ) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;	
	Object  obj = js.executeScript("return arguments[0].getAttribute('value')",e );
	String value = obj.toString();
	return value;
}
//setAttributeValue
public static void setAttributeValue(WebElement e, String txtvalue) {
	JavascriptExecutor js = (JavascriptExecutor)driver;	
	 js.executeScript("arguments[0].setAttribute('value','"+txtvalue+"')",e);
}
//click
public static void clickbtn(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",e);
}
//scroll up
public static void scrollup(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(false)", e);
}
//scroll down
public static void scroldown(WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", e);
}
//frames
public static void switchFrame(String locator) {
	driver.switchTo().frame(locator);

}
public static void switchFrame(int index) {
	driver.switchTo().frame(index);

}
public static void switchWebElement(  String WebElement ) {
	driver.switchTo().frame(WebElement );

}
// navigation commands
public static boolean displayed(WebElement e) {
	boolean displayed = e.isDisplayed();
	return displayed;

}
public static boolean enabled(WebElement e) {
	 boolean enabled = e.isEnabled();
	return enabled;
}
public static boolean selected(WebElement e) {
	 boolean selected = e.isSelected();
	return selected;}
//windows handle

public static String getWindowHandle() {
	String windowHandle = driver.getWindowHandle();
	return windowHandle;

}
public static Set<String> getWindowHandles() {
Set<String> windowHandles = driver.getWindowHandles();
return windowHandles;
//List<String> li = new ArrayList<>();
//li.all
}















}






