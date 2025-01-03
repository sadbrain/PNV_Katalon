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
WebUI.navigateToUrl(GlobalVariable.HEROKUAPP)

WebUI.click(findTestObject('Object Repository/verify_Dropdown/lnk_Dropdown'))

// Verify the header is 'Dropdown List'
String headerText = WebUI.getText(findTestObject('Object Repository/verify_Dropdown/hdr_DropdownList'))
WebUI.verifyEqual(headerText, "Dropdown List")

// Select 'Option 2' by label and verify the current item is 'Option 2'
WebUI.selectOptionByLabel(findTestObject('Object Repository/verify_Dropdown/ddl_Dropdown'), 'Option 2', false)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/verify_Dropdown/ddl_Dropdown'), "Option 2", false, 0)

// Select 'Option 1' by index and verify the current item is 'Option 1'
WebUI.selectOptionByIndex(findTestObject('Object Repository/verify_Dropdown/ddl_Dropdown'), 1)
WebUI.verifyOptionSelectedByIndex(findTestObject('Object Repository/verify_Dropdown/ddl_Dropdown'), 1, 0)

// Select 'Option 2' by value and verify the current item is 'Option 2'
WebUI.selectOptionByValue(findTestObject('Object Repository/verify_Dropdown/ddl_Dropdown'), '2', false)
WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/verify_Dropdown/ddl_Dropdown'), '2', false, 0)

WebUI.closeBrowser()

