package Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategory {
	//Declaration
	@FindBy(xpath="//b[text()='Add New Category']")
	private WebElement pageHeader;

	@FindBy(xpath="//input[@id='name']")
	private WebElement nameTf;

	@FindBy(name="add")
	private WebElement saveBtn;

	//Initialization
	public AddNewCategory(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization

	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void setName(String name) {
		nameTf.sendKeys(name);

	}
	public void clickSave() {
		saveBtn.click();
	}
}
