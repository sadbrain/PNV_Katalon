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

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Click to "Checkbox" title'
WebUI.click(findTestObject('Object Repository/Checkboxes_Page/lnk_CheckboxesTitle'))

'Verify that Checkboxes header title is displayed'
WebUI.verifyTextPresent('Checkboxes', false)

'Check checkbox 1'
if (!(WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 5, FailureHandling.OPTIONAL))) {
    WebUI.check(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'))
}

'Uncheck checkbox 2'
if (WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'), 5, FailureHandling.OPTIONAL)) {
    WebUI.uncheck(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'))
}

'Confirm checkbox 1 has been checked'
assert WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 5) == true

'Close browser'
WebUI.closeBrowser()

