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

//Step 1: Open Horizontal Slider and Verify Header
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_JQueryUIMenus'))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Verify_Menu/hdr_JQueryUIMenus')),'JQueryUI - Menu')

//Step 2: Choose Submenu and Verify
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_Enabled'))
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_SubMenuQueryMenu'))
WebUI.verifyElementText(findTestObject('Object Repository/Verify_Menu/hdr_JQueryUI'), 'JQuery UI')

//Step 3: Back Menu and Verify
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_Menu'))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Verify_Menu/hdr_JQueryUIMenus')),'JQueryUI - Menu')

//Step 4:
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_Enabled'))
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_SubMenuDownloads'))
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_SubMenuCSV'))

// Step 8: Kiểm tra file CSV được tải xuống
String downloadPath = 'C:\\Users\\lenovo\\Downloads\\'
String fileName = 'menu.csv'
File csvFile = new File(downloadPath + fileName)
assert csvFile.exists() == true : "File CSV không được tải xuống thành công"

WebUI.closeBrowser()