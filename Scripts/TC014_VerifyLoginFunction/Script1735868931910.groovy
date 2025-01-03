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

'Step 1: Open the browser and navigate to the login page'
WebUI.openBrowser(GlobalVariable.URL_ORANGE_DEMO)

'Step 2: Get username text from the Login form'
String usernameText = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Username'))

'Step 4: Enter "Admin" into the Username textbox'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Username'), GlobalVariable.USER_NAME)

'Step 5: Verify the username is entered successfully'
String enteredUsername = WebUI.getAttribute(findTestObject('Object Repository/Login_Page/txt_Username'), 'value')
WebUI.verifyMatch(enteredUsername, GlobalVariable.USER_NAME, false)

'Step 6: Get password text from the Login form'
String passwordText = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Password'))

'Step 7: Enter "admin123" into the password textbox'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'),  GlobalVariable.PASSWORD)

'Step 8: Verify the password is entered successfully'
String enteredPassword = WebUI.getAttribute(findTestObject('Object Repository/Login_Page/txt_Password'), 'value')
WebUI.verifyMatch(enteredPassword, GlobalVariable.PASSWORD, false)

'Step 9: '
'Click on the "Login" button in the login form'
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))

'Step 10: Wait for the Dashboard page to load'
WebUI.waitForPageLoad(10)

'Step 11: '
'Verify the Dashboard page title'
String expectedTitle = "Dashboard" 
String dashboardText = WebUI.getText(findTestObject('Object Repository/Login_Page/p_DashboardTitle'))
WebUI.verifyMatch(dashboardText, expectedTitle, false)

'Step 12: '
'Verify the control is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Step 13: '
'Select Logout in the User name control'
WebUI.click(findTestObject('Object Repository/Login_Page/p_UserControlName'))
WebUI.click(findTestObject('Object Repository/Login_Page/ddl_Logout'))

'Step 14: '
'Verify that the Login form is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/p_LoginTitle'), 10)

'Step 15: '
'Verify that the user control is disappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)


