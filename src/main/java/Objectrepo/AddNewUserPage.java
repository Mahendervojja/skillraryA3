package Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddNewUserPage {
	//Declaration
	@FindBy(xpath="//b[text()='Add New User']")
	private WebElement pageHeader;

	@FindBy(xpath="//input[@id='email' and @required]")
	private WebElement emailTf;


	@FindBy(xpath="//input[@id='password' and @required]")
	private WebElement passwordTf;


	@FindBy(xpath="//input[@id='firstname' and @required]")
	private WebElement firstNameTf;


	@FindBy(xpath="//input[@id='lastname' and @required]")
	private WebElement lastnameTf;


	@FindBy(xpath="//textarea[@id='address']")
	private WebElement addressTf;

	@FindBy(xpath="//input[@id='contact']")
	private WebElement contactInfoTf;

	@FindBy(xpath="(//input[@id='photo'])[2]")
	private WebElement uploadPhotoButton;

	@FindBy(xpath="//button[@name='add']")
	private WebElement saveButton;
	

	//Initialization

	public AddNewUserPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	//Utilization

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void setEmail(String email) {
		emailTf.sendKeys(email);
	}
	public void setpassword(String password) {
		passwordTf.sendKeys(password);
	}

	public void setFirstName(String firstname) {
		firstNameTf.sendKeys(firstname);
	}

	public void setLastName(String lastname) {
		lastnameTf.sendKeys(lastname);
	}

	public void setAddress(String Address) {
		addressTf.sendKeys(Address);
	}

	public void setContactInfo(String contactInfo) {
		contactInfoTf.sendKeys(contactInfo);
	}

	public void uploadPhoto(String Photo) {
		uploadPhotoButton.sendKeys(Photo);
	}

	public void clicksaveButton() {
		saveButton.click();
	}
	
	


}
