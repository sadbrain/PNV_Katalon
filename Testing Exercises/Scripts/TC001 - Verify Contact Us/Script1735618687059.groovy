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
WebUI.navigateToUrl('https://webdriveruniversity.com/Contact-Us/contactus.html')

WebUI.setText(findTestObject('Object Repository/Contact Us/txt_FirstName'),'John')
WebUI.setText(findTestObject('Object Repository/Contact Us/txt_LastName'), 'Doe')
WebUI.setText(findTestObject('Object Repository/Contact Us/txt_Email'),'test@gmail.com')
WebUI.setText(findTestObject('Object Repository/Contact Us/txtarea_Comment'),'This is a comment.')

WebUI.click(findTestObject('Object Repository/Contact Us/btn_Submit'))

boolean isMessageDisplayed = WebUI.verifyTextPresent('Thank You for your Message!', false)
if (isMessageDisplayed) {
	WebUI.comment('Test Passed: Message is displayed successfully.')
} else {
	WebUI.comment('Test Failed: Message is not displayed.')
}
