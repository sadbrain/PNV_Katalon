import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Step 1: Open the browser and navigate to the URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Step 2: Select "JavaScript Alerts" link'
WebUI.click(findTestObject('Object Repository/Page_VerifyAlerts/lnk_JavaScriptAlerts'))

'Verify that the page header contains "JavaScript Alerts"'
WebUI.verifyElementText(findTestObject('Object Repository/Page_VerifyAlerts/hdr_JavaScriptAlerts'), 'JavaScript Alerts')

'Step 3: Click "Click for JS Alert" button'
WebUI.click(findTestObject('Object Repository/Page_VerifyAlerts/btn_JSAlert'))

'Verify the alert message'
WebUI.verifyEqual(WebUI.getAlertText(), 'I am a JS Alert')

'Click "OK" to close the alert'
WebUI.acceptAlert()

'Verify the result message'
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Page_VerifyAlerts/lb_Result')).trim(), 'You successfully clicked an alert')

'Step 4: Click "Click for JS Confirm" button'
WebUI.click(findTestObject('Object Repository/Page_VerifyAlerts/btn_JSConfirm'))

'Verify the confirm alert message'
WebUI.verifyEqual(WebUI.getAlertText(), 'I am a JS Confirm')

'Click "Cancel" to close the confirm alert'
WebUI.dismissAlert()

'Verify the result message'
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Page_VerifyAlerts/lb_Result')).trim(), 'You clicked: Cancel')

'Step 5: Click "Click for JS Prompt" button'
WebUI.click(findTestObject('Object Repository/Page_VerifyAlerts/btn_JSPrompt'))

'Set text "Hello" in the prompt'
WebUI.setAlertText('Hello')

'Click "OK" to close the prompt alert'
WebUI.acceptAlert()

'Verify the result message'
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Page_VerifyAlerts/lb_Result')).trim(), 'You entered: Hello')

'Step 6: Close the browser'
WebUI.closeBrowser()
