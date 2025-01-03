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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

// Step 1: Go to the URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/lnk_JavaScriptAlert'))

// Verify "JavaScript Alerts" header title is displayed
String header = WebUI.getText(findTestObject('Object Repository/TC009 - Verify Alerts/h3_Header'))
WebUI.verifyEqual(header, 'JavaScript Alerts', FailureHandling.CONTINUE_ON_FAILURE)

// Step 2: Handle JavaScript Alert
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/btn_ClickForJSAlert'),FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyAlertPresent(10)
String alertMessage = WebUI.getAlertText()
assert alertMessage == 'I am a JS Alert' : "Unexpected alert message: ${alertMessage}"
WebUI.acceptAlert()
WebUI.verifyTextPresent('You successfully clicked an alert', false)

// Step 3: Handle JavaScript Confirm
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/btn_ClickDForJSConfirm'))
WebUI.dismissAlert() // Click "Cancel"
WebUI.verifyTextPresent('You clicked: Cancel', false)

// Step 4: Handle JavaScript Prompt
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/btn_ClickForrJSPrompt'))
WebUI.setAlertText('Hello')
WebUI.acceptAlert()
WebUI.verifyTextPresent('You entered: Hello', false)

// Close the browser
WebUI.closeBrowser()

