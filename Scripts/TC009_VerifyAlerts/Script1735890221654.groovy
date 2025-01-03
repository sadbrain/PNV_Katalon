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

// Step 1 : Go to https://the-internet.herokuapp.com/
WebUI.openBrowser(GlobalVariable.MENU_URL)

// Select 'JavaScript Alerts' link
WebUI.click(findTestObject('Object Repository/JavaScriptAlerts_Page/lnk_JavascriptAlerts'))

WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/JavaScriptAlerts_Page/lbl_JavaScriptAlertsTitle')), "JavaScript Alerts")

// 'JavaScript Alerts header title is displayed
TestObject textResult = findTestObject('Object Repository/JavaScriptAlerts_Page/lbl_TextResult')

// step 2 : Click 'Click for JS Alert' button
WebUI.click(findTestObject('Object Repository/JavaScriptAlerts_Page/btn_ClickJSAlert'))
WebUI.verifyMatch(WebUI.getAlertText(), 'I am a JS Alert', false)

// Step 3 : Click 'OK' button to close Alert
WebUI.acceptAlert()
WebUI.verifyEqual(WebUI.getText(textResult), "You successfully clicked an alert")

// Step 4 : Click 'I am a JS Confirm' button
WebUI.click(findTestObject('Object Repository/JavaScriptAlerts_Page/btn_ClickJSConfirm'))
WebUI.dismissAlert()

WebUI.verifyEqual(WebUI.getText(textResult), "You clicked: Cancel")

// Step 5 : Click 'Click for JS Prompt' button
WebUI.click(findTestObject('Object Repository/JavaScriptAlerts_Page/btn_ClickJSPrompt'))
// Set text "Hello"
WebUI.setAlertText('Hello')

// CLick ok button
WebUI.acceptAlert()

WebUI.verifyEqual(WebUI.getText(textResult), "You entered: Hello")

WebUI.closeBrowser()