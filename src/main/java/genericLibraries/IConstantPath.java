package genericLibraries;

public interface IConstantPath {
	/**
	 * This interface contains properties and excel files path
	 * @author vojja mahender
	 */
		String PROPERTIES_PATH=System.getProperty("user.dir")+"/src/test/resources/commondata.properties";
		String EXCEL_PATH=System.getProperty("user.dir")+"/src/test/resources/SkillRary TestData.xlsx";
}
