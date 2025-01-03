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

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.HRM)

// Step 1: Get User Name text and Get Password text from Login 
String usernameText = WebUI.getText(findTestObject('Object Repository/Verify_LoginFunction/lbl_UserNameText')).split(': ')[1]
String passwordText = WebUI.getText(findTestObject('Object Repository/Verify_LoginFunction/lbl_PasswordText')).split(': ')[1]

// Step 2: Input User Name and Password
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), usernameText)
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Password'), passwordText)

// Step 3: Verify the input values
// Check if the inputted value is equal to the username text
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), 'value'), usernameText, false)
// Check if the inputted value is equal to the password text
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Verify_LoginFunction/txt_Password'), 'value'), passwordText, false)

// Step 4: Click on the Login button
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/btn_Login'))

// Step 5: Verify The Dashboard page is loaded successfully
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/hdr_Dashboard'), 10)

// Step 6: Verify page title and user control displayed
// Check if the page title is correct (assuming you want to verify the title)
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Verify_LoginFunction/hdr_Dashboard')), "Dashboard")

//WebUI.verifyEqual(WebUI.getTitle(), "Dashboard")
// Check if the user control is displayed
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/btn_userControl'), 10)

// Step 7: Logout 
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/btn_Profile'))
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/lnk_Logout'))

// Step 8: Verify Logout successfully
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), 10)

// Step 9: Verify that the user control is disappeared and the Login form is displayed
// Check if the user control is no longer present
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Verify_LoginFunction/btn_userControl'), 10)
// Check if the login form is displayed
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), 10)

WebUI.closeBrowser()