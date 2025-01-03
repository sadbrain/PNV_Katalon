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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

// Mở trình duyệt và điều hướng đến URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/jqueryui/menu')

// Xác nhận rằng tiêu đề "JQueryUI - Menu" có mặt trên trang
WebUI.verifyTextPresent('JQueryUI - Menu', false)

// Bước 2: Hover và click vào mục menu "Enabled"
WebUI.waitForElementClickable(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Enabled'), 30)
WebUI.mouseOver(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Enabled'))
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Enabled'))

// Hover và click vào mục menu "JQuery UI menu"
WebUI.waitForElementClickable(findTestObject('Object Repository/TC013 - Verify Menu/mnu_JQueryUI'), 30)
WebUI.mouseOver(findTestObject('Object Repository/TC013 - Verify Menu/mnu_JQueryUI'))
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/mnu_JQueryUI'))

// Xác nhận tiêu đề của "JQuery UI" và quay lại trang "JQueryUI - Menu"
WebUI.verifyTextPresent("JQuery UI", false)
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/lnk_Menu'))

// Bước 3: Hover và click vào mục menu "Enabled"
WebUI.waitForElementClickable(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Enabled'), 30)
WebUI.mouseOver(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Enabled'))
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Enabled'))

// Hover và click vào mục menu "Downloads"
WebUI.waitForElementClickable(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Download'), 30)
WebUI.mouseOver(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Download'))
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/mnu_Download'))

// Click vào "CSV" và xác nhận rằng file đã được tải xuống
WebUI.waitForElementClickable(findTestObject('Object Repository/TC013 - Verify Menu/mnu_CSV'), 30)
WebUI.mouseOver(findTestObject('Object Repository/TC013 - Verify Menu/mnu_CSV'))
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/mnu_CSV'))


// Bước dọn dẹp: Đóng trình duyệt
WebUI.closeBrowser()
