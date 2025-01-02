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

"Step 1"
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/checkboxes')

"Step 2"
"Checkboxes header title is displayed"
WebUI.verifyTextPresent('Checkboxes', false, FailureHandling.CONTINUE_ON_FAILURE)

"Step 3"
"Checkbox button and un_button"
WebUI.check(findTestObject('Object Repository/TC004 - Verify Checkboxes/chk_checkbox1'))
WebUI.uncheck(findTestObject('Object Repository/TC004 - Verify Checkboxes/chk_uncheckbutton2'))

"Step 4"
"checkbox1 is checked and checkbox 2 is un-checked"
WebUI.verifyElementChecked(findTestObject('Object Repository/TC004 - Verify Checkboxes/chk_checkbox1'), 0, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/TC004 - Verify Checkboxes/chk_uncheckbutton2'), 0, FailureHandling.CONTINUE_ON_FAILURE)


