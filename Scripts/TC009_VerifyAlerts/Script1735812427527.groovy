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

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'Step 1: '
'Navigate to javaScript Alerts page'
WebUI.click(findTestObject('Object Repository/Javascript_Alerts_Page/lnk_JavaScriptAlerts'))

'Step 2: '
'Verify that "JavaScript Alerts" header title is displayed'
WebUI.verifyTextPresent(("JavaScript Alerts"), false)

'Step 3: '
'Click for JS Alert button'
WebUI.click(findTestObject('Object Repository/Javascript_Alerts_Page/btn_ClickForJSAlert'))

'Step 4 '
'Handle the alert and verify the alert message'
String alertText = WebUI.getAlertText()
WebUI.verifyMatch(alertText, "I am a JS Alert", false)

'Step 5 '
'Click "OK" to close the alert'
WebUI.acceptAlert()

'Step 6: '
'Verify the result message is displayed'
WebUI.verifyTextPresent("You successfully clicked an alert", false)

'Step 7 '
'Click I am a JS "Confirm" button'
WebUI.click(findTestObject('Object Repository/Javascript_Alerts_Page/btn_JavaScriptConfirm'))

'Step 8: '
'Handle the alert and click "Cancel"'
WebUI.dismissAlert()

'Step 9: '
'Verify the result message for clicking Cancel'
WebUI.verifyTextPresent("You clicked: Cancel", false)

'Step 10: '
'Click for JS Prompt'
WebUI.click(findTestObject('Object Repository/Javascript_Alerts_Page/btn_JavaScriptPrompt'))

'Step 11: '
'Ensure the alert is present before interacting'
WebUI.waitForAlert(10) 

'Step 12: '
'Set text "Hello" in the JS Prompt and click OK'
WebUI.setAlertText("Hello")
WebUI.acceptAlert()

'Step 13: '
'Verify the result message for entering text in the prompt'
WebUI.verifyTextPresent("You entered: Hello", false)
