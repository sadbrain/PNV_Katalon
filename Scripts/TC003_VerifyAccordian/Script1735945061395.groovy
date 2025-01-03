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

WebUI.openBrowser('')

// step 1 : Go to http://webdriveruniversity.com/Accordion/index.html
WebUI.navigateToUrl(GlobalVariable.ACCORDIAN_URL)
String expectedHiddenText = "This text has appeared after 5 seconds!"

String changedText  = "LOADING COMPLETE."
String initialText = "LOADING.. PLEASE WAIT.."

TestObject loadingObject = findTestObject('Object Repository/Accordian_Page/lbl_TextChange')
// verify text haven't change
WebUI.verifyEqual(WebUI.getText(loadingObject), initialText)

// Step 2 : Wait until "LOADING.. PLEASE WAIT.." text is changed to "LOADING COMPLETE." text
WebUI.waitForElementAttributeValue(
	loadingObject,
	'text', 
	changedText,
	10
)

// verify that text have changed
WebUI.verifyEqual(WebUI.getText(loadingObject), changedText)

// step 3: Click to "Keep Clicking! - Text will Appear After 5 Seconds!" accordian item
WebUI.click(findTestObject('Object Repository/Accordian_Page/btn_KeepClick'))

// Verify that the text "This text has appeared after 5 seconds!" is displayed.
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Accordian_Page/lbl_HiddenText')), expectedHiddenText)

WebUI.closeBrowser()