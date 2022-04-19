package org.browserlaunch;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
public	LoginPage() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement txtusername;
@FindBy(xpath="//input[@type='password']")
private WebElement txtpassword;
@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
private WebElement btnclick;

public WebElement getTxtusername() {
	return txtusername;
}
public WebElement getTxtpassword() {
	return txtpassword;
}
public WebElement getBtnclick() {
	return btnclick;
}








}
