import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

' Step 1: Open browser and navigate to URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

'Step 2: Get UserName from Login form and enter to Username field'
String rawUserName = WebUI.getText(findTestObject('Object Repository/014 - Verify Login Function/txt_TestDataDefaultUserName'))
String rawPassword = WebUI.getText(findTestObject('Object Repository/014 - Verify Login Function/txt_TestDataDefaultPassword'))

String UserName = rawUserName.split(':')[1].trim()
String Password = rawPassword.split(':')[1].trim()

WebUI.setText(findTestObject('Object Repository/014 - Verify Login Function/txt_UserName'), UserName)
WebUI.setText(findTestObject('Object Repository/014 - Verify Login Function/txt_Password'), Password)

WebUI.click(findTestObject('Object Repository/014 - Verify Login Function/btn_Login'))


'Step 3: Check page title and user control is displayed after log in successfully'
String expectedTitle = "Dashboard"
String dashboardText = WebUI.getText( findTestObject('Object Repository/015 - Verify main menu/txt_HeaderTitle'))
WebUI.verifyMatch(dashboardText, expectedTitle, false)

WebUI.verifyElementPresent( findTestObject('Object Repository/015 - Verify main menu/ddl_UserControl'), 10)

'Step 4: Click to the toggle menu button to collapse the menu'
WebUI.click( findTestObject('Object Repository/015 - Verify main menu/btn_CollapseMenu'))

'Step 5: Check the toggle button (<) is disappeared'
WebUI.verifyElementNotPresent( findTestObject('Object Repository/015 - Verify main menu/btn_CollapseMenu'),10)

'Step 6 Click the un-toggle menu button to open the menu'
WebUI.click( findTestObject('Object Repository/015 - Verify main menu/btn_CollapseMenu'))

'Step7: Verify that menu will be displayed completely'
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent( findTestObject('Object Repository/015 - Verify main menu/btn_CollapseMenu'),10)

'Step 8: Add text into txt "my info'
WebUI.setText( findTestObject('Object Repository/015 - Verify main menu/txt_Search'),  "My Info")

'Step 9: "Verify There is only My Info menu displays" '
List<WebElement> filteredSpans = WebUI.findWebElements( findTestObject('Object Repository/015 - Verify main menu/span_MyInfor'), 10)
boolean isOnlyMyInfoDisplayed = true

for (WebElement span : filteredSpans) {
	if (!span.getText().contains("My Info")) {
		isOnlyMyInfoDisplayed = false
		break
	}
}

WebUI.verifyEqual(isOnlyMyInfoDisplayed, true)

'Step 10:Type to Search textbox "D"'
WebUI.setText( findTestObject('Object Repository/015 - Verify main menu/txt_Search'),'D')
filteredSpans = WebUI.findWebElements( findTestObject('Object Repository/015 - Verify main menu/span_MyInfor'), 10,FailureHandling.CONTINUE_ON_FAILURE)
boolean isOnlyDMenusDisplayed = true

for (WebElement span : filteredSpans) {
	if (!span.getText().toLowerCase().contains("d")) {
		isOnlyDMenusDisplayed = false
		break
	}
}

WebUI.verifyEqual(isOnlyDMenusDisplayed, true, FailureHandling.CONTINUE_ON_FAILURE)

'Step 11:Click to "Dashboard" menu'
WebUI.click(findTestObject('Object Repository/015 - Verify main menu/txt_DashboradLink') )

'Verify Dashboard page is loaded successfully'
WebUI.waitForPageLoad(10)

'Verify page title and user control displayed'
WebUI.verifyElementPresent( findTestObject('Object Repository/015 - Verify main menu/txt_HeaderTitle'),10)
WebUI.verifyElementPresent(findTestObject('Object Repository/015 - Verify main menu/ddl_UserControl') , 10)

WebUI.closeBrowser()


