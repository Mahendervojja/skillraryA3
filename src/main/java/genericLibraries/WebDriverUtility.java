package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains reusable methods to perform driver related operations
 * @author vojja mahender
 *
 */

public class WebDriverUtility {
	private WebDriver driver;
	private Actions action;
	private Select select;
	/**
	 * This method launches the browser and maximize it
	 * @param browser
	 * @return
	 */
	public WebDriver launchAndMaximizeBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			break;
		}

		driver.manage().window().maximize();
		return driver;
	}
	/**
	 * This method is used to navigate to application
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);

	}
	/**
	 * This method is used to wait untill the element/elements are found
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait untill the element is visible on webpage
	 * @param timeInSec
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long timeInSec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method waits untill title of the webpage is displayed
	 * @param timeInSec
	 * @param title
	 * @return
	 */

	public Boolean explicitWait(long timeInSec, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		return wait.until(ExpectedConditions.titleContains(title));

	}
	/**
	 * This method is used to mouse hover on element
	 * @param element
	 */

	public void mouseHoverToElement(WebElement element) {
		action= new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to right on element
	 * @param element
	 */
	public void rightClickOnElement(WebElement element) {
		action= new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop the element to target location
	 * @param source
	 * @param target
	 */
	public void dragAndDrop( WebElement element,WebElement target) {
		action= new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}

	/**
	 * This method is used to select an element from dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectFromDropdown(WebElement element, int index) {
		select= new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from dropdown based on value
	 * @param element
	 * @param value
	 */

	public void selectFromDropdown(WebElement element, String value) {
		select= new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to select an element from dropdown based on visible text
	 * @param text
	 * @param element
	 */

	public void selectFromDropdown(String text,WebElement element) {
		select= new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method fetches Screenshot of the webpage
	 * @param driver
	 * @param jutil
	 * @param classname
	 */

	public void takeScreenshot(WebDriver driver,JavaUtility jutil, String classname) {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Screenshots/ "+ classname+"_"+jutil.getCurrentTime()+" .png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to scroll till the element
	 * @param element
	 */

	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}
	/**
	 * This method is used to switch to frame based on index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame based on id or name
	 * @param idOrName
	 */

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	/**
	 * This method is used to handle Alert popups
	 * @param status
	 */

	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			al.accept();
		else
			al.dismiss();
	}
	/**
	 * This method is used to switch to child browser
	 */

	public void switchToChildBrowser() {
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			driver.switchTo().window(windowId);
		}
	}
	/**
	 * This method fetches parent window address 
	 * @return
	 */

	public String getParentId() {
		return driver.getWindowHandle();
	}
	/**
	 * This method switches the control to specific window address
	 * @param windowId
	 */

	public void switchToWindow(String windowId) {
		driver.switchTo().window(windowId);
	}
	/**
	 * This method is used to close the window or tab
	 */
	public void closeWindow() {
		driver.close();
	}
	/**
	 * This method is used to close all windows and tabs
	 */
	public void quitAllWindows() {
		driver.quit();
	}
	/**
	 * This method converts  dynamic xpath to web element
	 * @param path
	 * @param replaceData
	 * @return
	 */

	public WebElement convertDynamicXpathToElement(String path, String replaceData) {
		String requiredPath=String.format(path, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}
	/**
	 * This method is used to switch into frame based on  Frame element reference
	 * @param frameElement
	 */

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch back from frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
}
