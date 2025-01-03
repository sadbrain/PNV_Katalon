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

'Step 1'
'Open brower and navigate to url'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/dropdown')

'Step 2'
'Verify header title is "Dropdown List"'
WebUI.verifyTextPresent('Dropdown List', false)

'Step 3'
WebUI.selectOptionByLabel(findTestObject('Object Repository/006 - Verify Dropdown/ddl_SelectOption') , 'Option 2', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.selectOptionByIndex( findTestObject('Object Repository/006 - Verify Dropdown/ddl_SelectOption'), 1)
WebUI.selectOptionByValue(findTestObject('Object Repository/006 - Verify Dropdown/ddl_SelectOption') , '2', false)

WebUI.closeBrowser()