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

WebUI.openBrowser('')
WebUI.navigateToUrl('http://webdriveruniversity.com/Accordion/index.html')


retries = 15
textChanged = false

for (int i = 0; i < retries; i++) {
	String currentText = WebUI.getText(findTestObject('Object Repository/Verify_Accordian/p_HiddenText'))
	if (currentText.contains('LOADING COMPLETE')) {
		textChanged = true
		break
	}
	WebUI.delay(2)
}

if (!textChanged) {
	WebUI.comment('Text did not change to "LOADING COMPLETE"')
	assert false
}

WebUI.click(findTestObject('Object Repository/Verify_Accordian/btn_KeepClicking'))

WebUI.verifyElementText(findTestObject('Object Repository/Verify_Accordian/txt_TextAfterClick'), 'This text has appeared after 5 seconds!')

WebUI.closeBrowser()
