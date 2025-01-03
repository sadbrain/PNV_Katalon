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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Pre-condition: Navigate to the OrangeHRM login page
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Step 1: Enter username
String username = 'Admin'
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), username)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), 'value'), username, false)

// Step 2: Enter password
String password = 'admin123' 
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Password'), password)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Verify_LoginFunction/txt_Password'), 'value'), password, false)

// Step 3: Click Login button
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/btn_Login'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Verify_LoginFunction/lbl_Dashboard'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Verify_LoginFunction/lbl_Dashboard'), 'Dashboard')

// Step 4: Logout
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/lnk_UserControl'))
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/lnk_Logout'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Verify_LoginFunction/frm_Login'), 10)
WebUI.verifyElementVisible(findTestObject('Object Repository/Verify_LoginFunction/frm_Login'))



