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
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

// 1. Mở trình duyệt và truy cập URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/Page_Dropdown/Lnk_Dropdown'))
WebUI.verifyElementText(findTestObject('Object Repository/Page_Dropdown/hdr_Dropdown List'), 'Dropdown List')
WebElement dropdown = WebUI.findWebElement(findTestObject('Object Repository/Page_Dropdown/ddl_DropdownList'))
Select select = new Select(dropdown)
select.selectByVisibleText('Option 2')
WebUI.verifyMatch(select.getFirstSelectedOption().getText(), 'Option 2', false)
select.selectByIndex(1)
WebUI.verifyMatch(select.getFirstSelectedOption().getText(), 'Option 1', false)
select.selectByValue('2')
WebUI.verifyMatch(select.getFirstSelectedOption().getText(), 'Option 2', false)
WebUI.closeBrowser()