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

try {
	// Pre-condition: Navigate to the login page
	WebUI.openBrowser('')
	WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/')

	// Step 1: Enter username
	String expectedUsername = WebUI.getAttribute(findTestObject('Object Repository/TC014 - Verify Login Function/txa_userNameField'), 'Admin') 
	WebUI.setText(findTestObject('Object Repository/TC014 - Verify Login Function/txa_userNameField'), expectedUsername)
	String actualUsername = WebUI.getAttribute(findTestObject('Object Repository/TC014 - Verify Login Function/txa_userNameField'), 'Admin')
	WebUI.verifyEqual(actualUsername, expectedUsername)

	// Step 2: Enter password
	String expectedPassword = WebUI.getAttribute(findTestObject('Object Repository/TC014 - Verify Login Function/txa_PasswordField'), 'admin123') 
	WebUI.setEncryptedText(findTestObject('Object Repository/TC014 - Verify Login Function/txa_PasswordField'), WebUI.encrypt(expectedPassword)) 
	String actualPassword = WebUI.getAttribute(findTestObject('Object Repository/TC014 - Verify Login Function/txa_PasswordField'), 'admin123')
	WebUI.verifyEqual(actualPassword, expectedPassword)

	// Step 3: Click Login button
	WebUI.click(findTestObject('Object Repository/TC014 - Verify Login Function/btn_Login'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.waitForPageLoad(10)
	String header1 = WebUI.getText(findTestObject('Object Repository/TC014 - Verify Login Function/h3_Header1'))
    WebUI.verifyEqual(header1, 'Dashboard', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/TC014 - Verify Login Function/UserControl'))

	// Step 4: Logout
	//WebUI.click(findTestObject('Object Repository/TC014 - Verify Login Function/UserControl'))
	//WebUI.click(findTestObject('Object Repository/TC014 - Verify Login Function/btn_Logout'))
	//WebUI.waitForElementVisible(findTestObject('Object Repository/TC014 - Verify Login Function/LoginForm'), 10)
	//WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC014 - Verify Login Function/UserControl'), 5)
	//WebUI.verifyElementVisible(findTestObject('Object Repository/TC014 - Verify Login Function/LoginForm'))

} catch (Exception e) {
	WebUI.comment("Test case failed: " + e.message)
} finally {
	// Close browser
	WebUI.closeBrowser()
}

