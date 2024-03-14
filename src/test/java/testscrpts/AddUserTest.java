package testscrpts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class AddUserTest extends BaseClass {
	@Test
	public void addUserTest() {
		SoftAssert soft= new SoftAssert();
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewbutton();
		soft.assertEquals(users.getPageHeader(), "Add New User");
		Map<String, String>map=excel.readFromExcel("Sheet1", "Add User");
		addNewUser.setEmail(map.get("Email"));
		addNewUser.setpassword(map.get("password"));
		addNewUser.setFirstName(map.get("FirstName"));
		addNewUser.setLastName(map.get("lastname"));
		addNewUser.setAddress(map.get("Address"));
		addNewUser.setContactInfo(map.get("Contact Info"));
		addNewUser.uploadPhoto(map.get("photo"));
		addNewUser.clicksaveButton();
		
		soft.assertTrue(users.getPageHeader().contains("Success"));
		users.deleteUser(web, map.get("Email"));
		
		soft.assertTrue(users.getSuccessAlertMessage().contains("User deleted successfully"));
		
		if(users.getSuccessAlertMessage().contains("User deleted successfully"))
			excel.updateTestStatus("Sheet1", "Add User", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Sheet1", "Add User", "Fail", IConstantPath.EXCEL_PATH);

		soft.assertAll();
	}
}
