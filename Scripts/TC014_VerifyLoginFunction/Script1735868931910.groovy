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

'Step 2 : Get username text from Login form to enter into Username textbox'
String userName = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_UserName'))
String userNameSplit = userName.split(":")[1].trim()
WebUI.verifyEqual(userNameSplit, "Admin")
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_UserName'),userNameSplit )

'Step 3 : Get password text from Login form to enter into Password textbox'
String password = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Password'))
String passwordSplit = password.split(":")[1].trim()
WebUI.verifyEqual(passwordSplit, "admin123")
WebUI.setText( findTestObject('Object Repository/Login_Page/txt_Password'), passwordSplit)

'Step 4: '
'Click on the "Login" button in the login form'
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))

'Step 5: Wait for the Dashboard page to load'
WebUI.waitForPageLoad(10)

'Step 6: '
'Verify the Dashboard page title'
String expectedTitle = "Dashboard" 
String dashboardText = WebUI.getText(findTestObject('Object Repository/Login_Page/p_DashboardTitle'))
WebUI.verifyMatch(dashboardText, expectedTitle, false)

'Step 7: '
'Verify the control is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Step 8: '
'Select Logout in the User name control'
WebUI.click(findTestObject('Object Repository/Login_Page/p_UserControlName'))
WebUI.click(findTestObject('Object Repository/Login_Page/ddl_Logout'))

'Step 9: '
'Verify that the Login form is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/p_LoginTitle'), 10)

'Step 10: '
'Verify that the user control is disappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Close Browser'
WebUI.closeBrowser()

