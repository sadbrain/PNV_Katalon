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

isTextChanged = false
expectedText  = 'LOADING COMPLETE.'
timeout = 30

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_ACCORDIAN)
currentText = WebUI.getText(findTestObject('Object Repository/Accordion_Page/p_HiddenText'))

'Step 1: '
'Wait until "LOADING.. PLEASE WAIT.." text is changed to "LOADING COMPLETE." text'
for (int i = 0; i < timeout; i++) {
	beforeText = currentText
	currentText = WebUI.getText(findTestObject('Object Repository/Accordion_Page/p_HiddenText'))
	if (currentText != beforeText) {
		isTextChanged = true
		break
	}
	WebUI.delay(1)
}

if (!isTextChanged) {
	WebUI.closeBrowser()
	assert false
}

'Verify the text has changed to "LOADING COMPLETE."'
WebUI.verifyMatch(currentText, expectedText, false)

'Step 2: '
'Click the "Keep Clicking! - Text will Appear After ${waitForTimeLoading} Seconds!" accordion item'
WebUI.click(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'))

'Step 3: '
'Verify that the text "This text has appeared after 5 seconds!" is displayed'
WebUI.verifyTextPresent("This text has appeared after 5 seconds!", false)

'Clean-up steps:'
WebUI.closeBrowser()