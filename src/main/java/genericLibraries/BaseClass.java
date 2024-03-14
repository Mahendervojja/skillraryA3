package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Objectrepo.AddNewCategory;
import Objectrepo.AddNewCoursePage;
import Objectrepo.AddNewUserPage;
import Objectrepo.CategoryPage;
import Objectrepo.CourseListPage;
import Objectrepo.HomePage;
import Objectrepo.LoginPage;
import Objectrepo.UsersPage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected LoginPage login;
	protected HomePage home;
	protected CourseListPage courseList;
	protected CategoryPage category;
	protected UsersPage users;
	protected AddNewUserPage addNewUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategory addCategory;
	
		@BeforeClass
		public void classConfig() {
		property=new PropertiesUtility();
		excel= new ExcelUtility();
		web= new WebDriverUtility();
		jutil= new JavaUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		driver= web.launchAndMaximizeBrowser(property.readProperty("browser"));
		web.waitTillElementFound(Long.parseLong(property.readProperty("timeouts")));
		
		sdriver=driver;
		sjutil=jutil;
		}
		@BeforeMethod
		public void methodConfig() {
			login= new LoginPage(driver);
			home= new HomePage(driver);
			users= new UsersPage(driver);
			courseList= new CourseListPage(driver);
			category= new CategoryPage(driver);
			addNewUser= new AddNewUserPage(driver);
			addCourse= new AddNewCoursePage(driver);
			addCategory= new AddNewCategory(driver);
			
			excel.excelInit(IConstantPath.EXCEL_PATH);
			web.navigateToApp(property.readProperty("url"));
			Assert.assertEquals(login.getPageHeader(), "Login");
			login.loginToApp(property.readProperty("username"), property.readProperty("password"));
			
			Assert.assertEquals(home.getPageHeader(), "Home");
		}
		
		@AfterMethod
		public void methodTearDown() {
			home.signOut();
		}
		
		@AfterClass
		public void classTearDown() {
			web.quitAllWindows();
		}
		
		
}
