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

import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Mở trình duyệt và đi đến trang
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

// Chờ để link 'Checkboxes' xuất hiện và click vào
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes/link_Checkboxes'), 10)
WebUI.click(findTestObject('Object Repository/Checkboxes/link_Checkboxes'))

// Xác nhận tiêu đề Checkboxes xuất hiện
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes/header_Title'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Checkboxes/header_Title'), 'Checkboxes')

// Kiểm tra trạng thái của checkbox 1 và checkbox 2
if (!WebUI.isChecked(findTestObject('Object Repository/Checkboxes/checkbox_1'))) {
	WebUI.check(findTestObject('Object Repository/Checkboxes/checkbox_1'))  // Chọn checkbox 1 nếu chưa được chọn
}

if (WebUI.isChecked(findTestObject('Object Repository/Checkboxes/checkbox_2'))) {
	WebUI.uncheck(findTestObject('Object Repository/Checkboxes/checkbox_2'))  // Bỏ chọn checkbox 2 nếu đã được chọn
}

// Xác nhận trạng thái checkbox sau khi thay đổi
WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes/checkbox_1'), 5)  // Kiểm tra checkbox 1 đã được chọn
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Checkboxes/checkbox_2'), 5)  // Kiểm tra checkbox 2 không được chọn

// Đóng trình duyệt
WebUI.closeBrowser()
