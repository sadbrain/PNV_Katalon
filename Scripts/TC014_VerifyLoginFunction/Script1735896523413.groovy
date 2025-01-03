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

WebUI.openBrowser(GlobalVariable.LOGIN_URL)

// Step 1 : Get username text from Login form to enter into Username textbox
String userName = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_UserName'))
String userNameSplit = userName.split(":")[1].trim()
WebUI.verifyEqual(userNameSplit, "Admin")
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_UserName'),userNameSplit )

// Step 2 : Get password text from Login form to enter into Password textbox
String password = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Password'))
String passwordSplit = password.split(":")[1].trim()
WebUI.verifyEqual(passwordSplit, "admin123")
WebUI.setText( findTestObject('Object Repository/Login_Page/txt_Password'), passwordSplit)

// Step 3 : Click Login button
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Submit'))

WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Dashboard')), 'Dashboard')
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 0)

// Step 4 : Select Logout in the User name control
WebUI.click(findTestObject('Object Repository/Login_Page/ddl_UserMenuList') )
WebUI.waitForElementPresent(findTestObject('Object Repository/Login_Page/ddl_MenuList') , 2)
WebUI.click(findTestObject('Object Repository/Login_Page/lnk_Logout'))

// verify the user control is disappeared and the Login form is displayed
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_LoginTite')), "Login")

WebUI.closeBrowser()
