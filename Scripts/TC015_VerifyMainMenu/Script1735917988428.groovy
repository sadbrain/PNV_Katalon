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

// Step 1: Login
String usernameText = WebUI.getText(findTestObject('Object Repository/Verify_MainMenu/lbl_UserNameText')).split(': ')[1]
String passwordText = WebUI.getText(findTestObject('Object Repository/Verify_MainMenu/lbl_PasswordText')).split(': ')[1]
WebUI.setText(findTestObject('Object Repository/Verify_MainMenu/txt_Username'), usernameText)
WebUI.setText(findTestObject('Object Repository/Verify_MainMenu/txt_Password'), passwordText)
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/btn_Login'))

// Step 2: Verify the Dashboard & User Control
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/hdr_Dashboard'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/btn_UserControl'), 5)

// Step 3: Close the menu
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/btn_MainMenu'))

// Step 4: Expand the menu
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/btn_MainMenu'))

// Step 6: Search for "My Info"
WebUI.setText(findTestObject('Object Repository/Verify_MainMenu/txt_Search'), 'My Info')
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/txt_MenuInfo'), 5)

// Step 7: Clear the search field by sending a string with only backspace (to simulate deleting all text)
WebUI.sendKeys(findTestObject('Object Repository/Verify_MainMenu/txt_Search'), Keys.chord(Keys.CONTROL, 'a'))  // Select all text
WebUI.sendKeys(findTestObject('Object Repository/Verify_MainMenu/txt_Search'), Keys.BACK_SPACE.toString())  // Delete selected text

// Step 8: Search for "D"
WebUI.setText(findTestObject('Object Repository/Verify_MainMenu/txt_Search'), 'D')

// Step 9: Click on the Dashboard Menu
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/btn_Dasboard'))
// Verify page title and user control are displayed
WebUI.verifyElementText(findTestObject('Object Repository/Verify_LoginFunction/hdr_Dashboard'), 'Dashboard')
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/btn_UserControl'), 5)

WebUI.closeBrowser()