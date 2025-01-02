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

// step 1 : Go to http://webdriveruniversity.com/Accordion/index.html
WebUI.openBrowser(GlobalVariable.URL_ACCORDION)

int timeout = 10 // Maximum time
int elapsed = 0 //elapsed time

String expectedTimeoutText = 'This text has appeared after 5 seconds!'
String expectedChange = 'LOADING COMPLETE.'
String textChange

while (elapsed < timeout) {
	textChange = WebUI.getText(findTestObject('Object Repository/Accordion_page/lbl_HiddenText') , FailureHandling.CONTINUE_ON_FAILURE)
	if (textChange == 'LOADING COMPLETE.') {
		break
	}
	WebUI.delay(1)
	elapsed++
}

// Verify
WebUI.verifyMatch(textChange, expectedChange, false, FailureHandling.CONTINUE_ON_FAILURE)

// Step 2: Click to "Keep Clicking! - Text will Appear After 5 Seconds!" accordian item
WebUI.click(findTestObject('Object Repository/Accordion_page/btn_KeepClick'), FailureHandling.CONTINUE_ON_FAILURE)
String textTimeout = WebUI.getText(findTestObject('Object Repository/Accordion_page/lbl_TimeoutText'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyEqual(textTimeout,expectedTimeoutText , FailureHandling.CONTINUE_ON_FAILURE)

// close browser
WebUI.closeBrowser()



