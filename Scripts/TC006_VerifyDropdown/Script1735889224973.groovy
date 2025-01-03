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

// STep 1 : 
WebUI.openBrowser(GlobalVariable.MENU_URL)
// Select 'Dropdown' link
WebUI.click(findTestObject('Object Repository/Dropdown_Page/lnk_Dropdown'))

// verify text title
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Dropdown_Page/lbl_DropdownTitle')), "Dropdown List")

// Step 2: Select item by label ''Option 2'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Dropdown_Page/ddl_DropdownList'), 'Option 2', false)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Dropdown_Page/ddl_DropdownList') , "Option 2", false, 0)

// Step 3 : Select item by index 1
WebUI.selectOptionByIndex(findTestObject('Object Repository/Dropdown_Page/ddl_DropdownList') , 1)
WebUI.verifyOptionSelectedByIndex(findTestObject('Object Repository/Dropdown_Page/ddl_DropdownList') , 1, 1)

// Step 4: Select item by value 2
WebUI.selectOptionByValue(findTestObject('Object Repository/Dropdown_Page/ddl_DropdownList'), "2", false)
WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/Dropdown_Page/ddl_DropdownList'), "2", false, 2)

WebUI.closeBrowser()
