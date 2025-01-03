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

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'step 1: '
'Click Dropdown link'
WebUI.click(findTestObject('Object Repository/Heroku_Page/lnk_Dropdown'))

'Verify Dropdown List header title is displayed'
String title = WebUI.getText(findTestObject('Object Repository/Dropdown_Page/h3_DropListTitle'))
WebUI.verifyEqual(title, 'Dropdown List', FailureHandling.CONTINUE_ON_FAILURE)

'step 2: '
'Select item by label'
WebUI.selectOptionByLabel( findTestObject('Object Repository/Dropdown_Page/ddl_DropList'), 'Option 2', false, FailureHandling.CONTINUE_ON_FAILURE)
'Verifying the Option is Selected by Label option: Option 2'
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Dropdown_Page/ddl_DropList'), 'Option 2', false, 0, FailureHandling.CONTINUE_ON_FAILURE)

'step 3: '
'Select item by index 1'
WebUI.selectOptionByIndex(findTestObject('Object Repository/Dropdown_Page/ddl_DropList') , 1, FailureHandling.CONTINUE_ON_FAILURE)
'Verifying the Option is Selected by Index option: 1'
WebUI.verifyOptionSelectedByIndex(findTestObject('Object Repository/Dropdown_Page/ddl_DropList'), 1, 0, FailureHandling.CONTINUE_ON_FAILURE)

'step 4: '
' Select item by value 2'
WebUI.selectOptionByValue(findTestObject('Object Repository/Dropdown_Page/ddl_DropList') , '2', false, FailureHandling.CONTINUE_ON_FAILURE)
'verify the Option is select by Value : Option 2'
WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/Dropdown_Page/ddl_DropList'), '2', false, 0, FailureHandling.CONTINUE_ON_FAILURE)

'Clean-up steps:'
WebUI.closeBrowser()