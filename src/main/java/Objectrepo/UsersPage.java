package Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class UsersPage {
	//Declaration
	@FindBy(xpath="//h1[normalize-space(text())='Users']")
	private WebElement pageHeader;

	@FindBy(xpath="//a[text()=' New']")
	private WebElement newButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private WebElement successAlert;
	
	private String deleteUser="//td[text()='%s']/following-sibling::td/button[text()=' Delete']";
	
	



	//initialization
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickNewbutton() {
		newButton.click();
	}
	
	public String getSuccessAlertMessage() {
		return successAlert.getText();
		
	}
	
	public void deleteUser(WebDriverUtility web,String email) {
		web.convertDynamicXpathToElement(deleteUser, email);
	}
	
	

}
