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

'Click on the dropdown menu to expand the options'
WebUI.click(findTestObject('Object Repository/Dropdown_Page/ddl_Dropdown'))

'Verify that the Dropdown List header title is displayed'
WebUI.verifyTextPresent('Dropdown List', false)

'Select an item by its value 2 (corresponding to "Option 2")'
WebUI.selectOptionByValue(findTestObject('Object Repository/Dropdown_Page/ddl_Select'), '2', true)

'Retrieve the current value of the dropdown and verify it is 2'
String currentItemByLabel = WebUI.getAttribute(findTestObject('Object Repository/Dropdown_Page/ddl_Select'), 'value')
WebUI.verifyMatch(currentItemByLabel, '2', false, FailureHandling.CONTINUE_ON_FAILURE)

'Select an item by its index 1 (corresponding to "Option 1")'
WebUI.selectOptionByIndex(findTestObject('Object Repository/Dropdown_Page/ddl_Select'), 1)

'Retrieve the current value of the dropdown and verify it is 1'
String currentItemByIndex = WebUI.getAttribute(findTestObject('Object Repository/Dropdown_Page/ddl_Select'), 'value')
WebUI.verifyMatch(currentItemByIndex, '1', false, FailureHandling.CONTINUE_ON_FAILURE)

'Select an item by its value 2 (corresponding to "Option 2")'
WebUI.selectOptionByValue(findTestObject('Object Repository/Dropdown_Page/ddl_Select'), '2', false)

'Retrieve the current value of the dropdown and verify it is 2'
String currentItemByValue = WebUI.getAttribute(findTestObject('Object Repository/Dropdown_Page/ddl_Select'), 'value')
WebUI.verifyMatch(currentItemByValue, '2', false, FailureHandling.CONTINUE_ON_FAILURE)

'Close browser'
WebUI.closeBrowser()



