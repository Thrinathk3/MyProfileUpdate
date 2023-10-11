
package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.utils.LogUtils;
import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.UpdatePage;
/**
 * Contains the tests related to Orange HRM page. For more details,
 * 
 * <pre>
 * <b>
 * <a href="https://www.youtube.com/channel/UC6PTXUHb6j4Oxf0ccdRI11A">Testing Mini Bytes Youtube channel</a>
 * </b>
 * </pre>
 * 
 * Jan 22, 2023 
 * @author Thrinath K
 * @version 1.0
 * @since 1.0
 */
public class UpdateTest extends BaseTest{
	private UpdateTest() {}
	/**
	 * Test Name mentioned here should match the column name "testname" in excel sheet.This is mandatory to run this
	 * test. Otherwise it will be ignored.
	 * The match has to be there in both of the RUNMANAGER and TESTDATA sheet
	 * Set the authors who have the created the test which will be logged to the reports
	 * Set the category which this particular test case belongs to
	 * @author Thrinath K
	 * Jan 22, 2023
	 * @param data HashMap containing all the values of test data needed to run the tests
	 */
	@Test
	@FrameworkAnnotation(author= {"Thrinath","Tingu"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void profileTest(Map<String,String> data) {
		/*String date = new UpdatePage().clickLogin()
				.enterUserName(data.get("username"))
				.enterPassWord(data.get("password"))
				.clickLoginButton()
				.clickProfile()
				.viewProfile()
				.updatingResume(data.get("menutext"))
				.getDate();*/
		String text = new UpdatePage().clickLogin()
				.enterUserName(data.get("username"))
				.enterPassWord(data.get("password"))
				.clickLoginButton()
				.clickProfile()
				.viewProfile()
				.clickEditResumeHeadline()
				.saveResumeHeadline()
				.updatingResume(data.get("menutext"))
				.getText();
		System.out.println("*************************************************\n*\t\t "+text+
				"\t\t\t*\n*************************************************");
		LogUtils.error("Driver session is not available" );

		//Assertions.assertThat(date).isNotNull();
		Assertions.assertThat(text).contains("Success");
	}


}
