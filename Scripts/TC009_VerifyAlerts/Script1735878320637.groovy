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
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys as Keys

// Step 1: Open the browser
WebUI.openBrowser('')

// Step 2: Navigate to the URL provided in GlobalVariable
WebUI.navigateToUrl(GlobalVariable.HEROKUAPP)

// Step 3: Click on the "JavaScript Alerts" link
WebUI.click(findTestObject('Object Repository/verify_Alerts/lnk_JavaScriptAlerts'))

// Step 4: Verify the header is "JavaScript Alerts"
String headerText = WebUI.getText(findTestObject('Object Repository/verify_Alerts/hdr_JavaScriptAlerts'))
WebUI.verifyEqual(headerText, "JavaScript Alerts")

// Step 5: Click on the "Click for JS Alert" button
WebUI.click(findTestObject('Object Repository/verify_Alerts/btn_JSAlert'))

// Step 6: Verify that the alert displays "I am a JS Alert"
WebUI.delay(2) // Wait for 2 seconds before accepting the alert
String alertText = WebUI.getAlertText()
WebUI.verifyEqual(alertText, "I am a JS Alert")
WebUI.acceptAlert()

// Step 7: Verify that after accepting the alert, the message "You successfully clicked an alert" is displayed
String successMessage = WebUI.getText(findTestObject('Object Repository/verify_Alerts/msg_AlertSuccess'))
WebUI.verifyEqual(successMessage, "You successfully clicked an alert")

// Step 8: Click on the "I am a JS Confirm" button and dismiss the alert
WebUI.click(findTestObject('Object Repository/verify_Alerts/btn_JSConfirm'))
WebUI.delay(2)
WebUI.dismissAlert()

// Step 9: Verify that after clicking Cancel, the message "You clicked: Cancel" is displayed
String cancelMessage = WebUI.getText(findTestObject('Object Repository/verify_Alerts/msg_ConfirmCancel'))
WebUI.verifyEqual(cancelMessage, "You clicked: Cancel")

// Step 10: Click on the "Click for JS Prompt" button, input "Hello" and accept the alert
WebUI.click(findTestObject('Object Repository/verify_Alerts/btn_JSPrompt'))
WebDriver driver = DriverFactory.getWebDriver()
driver.switchTo().alert().sendKeys('Hello') // Enter "Hello" in the prompt
WebUI.delay(2) // Wait for 2 seconds
WebUI.acceptAlert()

// Step 11: Verify that after accepting the prompt, the message "You entered: Hello" is displayed
String promptMessage = WebUI.getText(findTestObject('Object Repository/verify_Alerts/msg_PromptSuccess'))
WebUI.verifyEqual(promptMessage, "You entered: Hello")

// Step 12: Close the browser
WebUI.closeBrowser()
