package org.base;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends BaseClass {
public static void main(String[] args) {

launchBrowser("chrome");
launchUrl("https://www.facebook.com/");
WebElement txtusername = findElement("id","email" );
txtusername.sendKeys("reshma");
WebElement txtpassword = findElement("id", "pass");
txtpassword.sendKeys("127845");
driver.navigate().refresh();
WebElement txtusername1 = findElement("id","email" );
txtusername1.sendKeys("reshma");
WebElement txtpassword1 = findElement("id", "pass");
txtpassword1.sendKeys("12345");
//WebElement btnlogin = findElement("name", "login");
//btnlogin.click();
 
}
}
