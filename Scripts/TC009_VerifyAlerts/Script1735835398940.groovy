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

// step 1: Go to https://the-internet.herokuapp.com/ and  Select 'JavaScript Alerts' link
WebUI.openBrowser(GlobalVariable.URL_HERROKUAPP, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/JavaScriptAlert_Page/lnk_JavaScriptAlert') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify 'JavaScript Alerts header title is displayed
WebUI.verifyTextPresent('JavaScript Alerts', false, FailureHandling.CONTINUE_ON_FAILURE)

// step 2: Click 'Click for JS Alert' button
WebUI.click(findTestObject('Object Repository/JavaScriptAlert_Page/btn_ClickForJSAlert') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify 'I am a JS Alert' message is displayed
//Handle the alert and verify the alert message
String alertText = WebUI.getAlertText()
WebUI.verifyMatch(alertText, 'I am a JS Alert', false, FailureHandling.CONTINUE_ON_FAILURE)

// step 3: Click 'OK' button to close Alert
WebUI.acceptAlert()
// Verify the result message is displayed
WebUI.verifyTextPresent('You successfully clicked an alert', false, FailureHandling.CONTINUE_ON_FAILURE)

// step 4: Click 'I am a JS Confirm' button
WebUI.click( findTestObject('Object Repository/JavaScriptAlert_Page/btn_JSConfirm'), FailureHandling.CONTINUE_ON_FAILURE)
// Handle the alert and click "Cancel"
WebUI.dismissAlert()
// Verify the result message for clicking Cancel
WebUI.verifyTextPresent("You clicked: Cancel", false, FailureHandling.CONTINUE_ON_FAILURE)

// step 10: Click for JS Prompt'
WebUI.click( findTestObject('Object Repository/JavaScriptAlert_Page/btn_JSPrompt'), FailureHandling.CONTINUE_ON_FAILURE)
// Ensure the alert is present before interacting'
WebUI.waitForAlert(10)
// Set text "Hello" in the JS Prompt and click OK'
WebUI.setAlertText('Hello', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.acceptAlert()
// Verify the result message for entering text in the prompt
WebUI.verifyElementText(findTestObject('Object Repository/JavaScriptAlert_Page/p_Result') , 'You entered: Hello', FailureHandling.CONTINUE_ON_FAILURE)

// Close Browser
WebUI.closeBrowser()