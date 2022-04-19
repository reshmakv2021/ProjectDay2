package org.browserlaunch;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearch extends BaseClass {
	public	ProductSearch() {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//input[@class='_3704LK']")
private WebElement Search;
	@FindBy(className="//button[@class='L0Z3Pu']")
private WebElement Searchbtn;
	
public WebElement getSearch() {
	return Search;
}
public WebElement getSearchbtn() {
	return Searchbtn;
}

}
	
	
	
