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
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys


'Step 1: Open the browser and navigate to the login page'
WebUI.openBrowser(GlobalVariable.URL_ORANGE_DEMO)

'Step 2: Enter the Username into the textbox'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Username'), GlobalVariable.USER_NAME)

'Step 3: Verify the username is entered successfully'
String enteredUsername = WebUI.getAttribute(findTestObject('Object Repository/Login_Page/txt_Username'), 'value')
WebUI.verifyMatch(enteredUsername, GlobalVariable.USER_NAME, false)

'Step 4: Enter the password into the textbox'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'),  GlobalVariable.PASSWORD)

'Step 5: Verify the password is entered successfully'
String enteredPassword = WebUI.getAttribute(findTestObject('Object Repository/Login_Page/txt_Password'), 'value')
WebUI.verifyMatch(enteredPassword, GlobalVariable.PASSWORD, false)

'Step 6: '
'Click on the "Login" button in the login form'
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))

'Step 7: Wait for the Dashboard page to load'
WebUI.waitForPageLoad(10)

'Step 8: '
'Verify the Dashboard page title'
String expectedTitle = "Dashboard"
String dashboardText = WebUI.getText(findTestObject('Object Repository/Login_Page/p_DashboardTitle'))
WebUI.verifyMatch(dashboardText, expectedTitle, false)

'Step 9: '
'Verify the control is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Step 10: '
'Click the toggle menu button to collapse the menu'
WebUI.click(findTestObject('Object Repository/Main_Menu_Page/btn_ToggleMenu'))

'Step 11: '
'Verify that the menu is collapsed completely and the toggle button (<) is disappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Main_Menu_Page/ic_LeftToggle'), 10)

'Step 13: '
'Click the un-toggle menu button to open the menu'
WebUI.click(findTestObject('Object Repository/Main_Menu_Page/btn_ToggleMenu'))

'Step 14: '
'Verify that The menu will be displayed completely'
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Main_Menu_Page/ic_LeftToggle'), 10)

'Step 15: '
'Type to Search textbox "My Info"'
WebUI.setText(findTestObject('Object Repository/Main_Menu_Page/txt_Search'), "My Info")

'Step 16: '
"Verify There's only My Info menu displays'"
List<WebElement> filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/Main_Menu_Page/span_MyMenu'), 10)
boolean isOnlyMyInfoDisplayed = true

for (WebElement span : filteredSpans) {
	if (!span.getText().contains("My Info")) {
		isOnlyMyInfoDisplayed = false
		break
	}
}

WebUI.verifyEqual(isOnlyMyInfoDisplayed, true)

'Clear text in the search field'
WebUI.sendKeys(findTestObject('Object Repository/Main_Menu_Page/txt_Search'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Main_Menu_Page/txt_Search'), Keys.chord(Keys.BACK_SPACE))


'Step 17: '
'Type to Search textbox "D"'
WebUI.setText(findTestObject('Object Repository/Main_Menu_Page/txt_Search'), 'D')
filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/Main_Menu_Page/span_MyMenu'), 10, FailureHandling.STOP_ON_FAILURE)
boolean isOnlyDMenusDisplayed = true

for (WebElement span : filteredSpans) {
	if (!span.getText().toLowerCase().contains("d")) {
		isOnlyDMenusDisplayed = false
		break
	}
}

WebUI.verifyEqual(isOnlyDMenusDisplayed, true, FailureHandling.STOP_ON_FAILURE)

'Step 18: '
'Click to "Dashboard" menu'
WebUI.click(findTestObject('Object Repository/Main_Menu_Page/lnk_Dasboard'))

'Verify Dashboard page is loaded successfully'
WebUI.waitForPageLoad(10)

'Verify page title and user control displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/p_DashboardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Clean-up steps:'
WebUI.closeBrowser()
