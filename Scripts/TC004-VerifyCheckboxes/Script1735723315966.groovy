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
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

WebUI.verifyTextPresent('Checkboxes', false)
WebUI.click(findTestObject('Object Repository/CheckboxesPage/lnk_Checkboxes'))

if (!(WebUI.verifyElementChecked(findTestObject('Object Repository/CheckboxesPage/chk_Checkbox1'), 5, FailureHandling.OPTIONAL))) {
    WebUI.check(findTestObject('Object Repository/CheckboxesPage/chk_Checkbox1'))
}

if (WebUI.verifyElementChecked(findTestObject('Object Repository/CheckboxesPage/chk_Checkbox2'), 5, FailureHandling.OPTIONAL)) {
    WebUI.uncheck(findTestObject('Object Repository/CheckboxesPage/chk_Checkbox2'))
}

assert WebUI.verifyElementChecked(findTestObject('Object Repository/CheckboxesPage/chk_Checkbox1'), 5) == true
WebUI.closeBrowser()
