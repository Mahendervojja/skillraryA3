package testscrpts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;



public class AddCatageryTest extends BaseClass
{
	@Test 
	public void addCatageryTest() {
		SoftAssert soft =new SoftAssert();
		home.clickCourseListLink();
		home.clickCategoryLink();
		AssertJUnit.assertTrue(category.getPageHeader().contains("Category"));
		category.clickNewButton();
		AssertJUnit.assertEquals(addCategory.getPageHeader(),"add new Category");
		Map<String,String> map = excel.readFromExcel("Sheeet1","add category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		AssertJUnit.assertTrue(courseList.getSuccessAlertMessage().contains("categery added succussfully ")) ;
		courseList.deleteCourse(web,map.get("Name"));
		AssertJUnit.assertTrue(courseList.getSuccessAlertMessage().contains("Course deleted Successfully"));
		if(courseList.getSuccessAlertMessage().contains("Product deleted Successfully"))
			excel.updateTestStatus("Sheet1","Add course","Pass",IConstantPath.EXCEL_PATH);
		else 
			excel.updateTestStatus("Sheet1","Add Course","fail",IConstantPath.EXCEL_PATH);
		soft.assertAll();
		
		
		
		 
	}

}
