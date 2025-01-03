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

WebUI.navigateToUrl('https://the-internet.herokuapp.com')

// Step 2: Click on the "Drag and Drop" link to access the Drag and Drop page
WebUI.click(findTestObject('Object Repository/TC006 - Verify Dropdown/lnk_DropDown'))
//Step 3 
WebUI.selectOptionByLabel(findTestObject('Object Repository/TC006 - Verify Dropdown/ddl_DropDown'), 'Option 2', false)
 

// Kiểm tra item hiện tại
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/TC006 - Verify Dropdown/ddl_DropDown'), 'Option 2', false, 10)
// Bước 3: Chọn item theo chỉ mục (index 1)
WebUI.selectOptionByIndex(findTestObject('Object Repository/TC006 - Verify Dropdown/ddl_DropDown'), 1)

// Kiểm tra item hiện tại
WebUI.verifyOptionSelectedByIndex(findTestObject('Object Repository/TC006 - Verify Dropdown/ddl_DropDown'), 1, 10)
// Bước 4: Chọn item theo giá trị (value 2)
WebUI.selectOptionByValue(findTestObject('Object Repository/TC006 - Verify Dropdown/ddl_DropDown'), '2', false)

// Kiểm tra item hiện tại
WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/TC006 - Verify Dropdown/ddl_DropDown'), '2', false, 60)