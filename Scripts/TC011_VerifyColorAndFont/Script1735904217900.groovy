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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Phương thức chuyển đổi từ RGBA sang Hex
def rgbaToHex(String rgba) {
	// Tách các giá trị RGBA từ chuỗi
	def rgbaValues = rgba.replaceAll("[^0-9,]", "").split(",")
	
	// Chuyển đổi từ các giá trị rgba sang hex
	int r = Integer.parseInt(rgbaValues[0])
	int g = Integer.parseInt(rgbaValues[1])
	int b = Integer.parseInt(rgbaValues[2])
	
	// Tạo chuỗi hex
	String hex = String.format("#%02X%02X%02X", r, g, b)
	
	return hex
}

// Mở trình duyệt
WebUI.openBrowser('')

// Điều hướng đến URL
WebUI.openBrowser('https://the-internet.herokuapp.com/')

// Nhấn vào liên kết "Challenging DOM"
WebUI.click(findTestObject('Object Repository/Verify_ColorAndFont/lnk_ChallengingDOM'))

// Bước 1: Kiểm tra tiêu đề
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Verify_ColorAndFont/lbl_ChallengingDOM')), "Challenging DOM")

// Bước 2: Kiểm tra font size của nút Button1
String fontSize = WebUI.getCSSValue(findTestObject('Object Repository/Verify_ColorAndFont/btn_Button1'), 'font-size')
WebUI.verifyEqual(fontSize, "16px")

// Bước 3: Kiểm tra background-color của nút Button2
String backgroundColor = WebUI.getCSSValue(findTestObject('Object Repository/Verify_ColorAndFont/btn_Button2'), 'background-color')

// Chuyển đổi từ rgba sang hex
String hexBackgroundColor = rgbaToHex(backgroundColor)

// Kiểm tra giá trị hex của background-color
WebUI.verifyEqual(hexBackgroundColor, '#C60F13')

// Bước 4: Kiểm tra border-color của nút Button3
String borderColor = WebUI.getCSSValue(findTestObject('Object Repository/Verify_ColorAndFont/btn_Button3'), 'border-color')

// Chuyển đổi từ rgba sang hex
String hexBorderColor = rgbaToHex(borderColor)

// Kiểm tra giá trị hex của border-color
WebUI.verifyEqual(hexBorderColor, '#457A1A')

// Đóng trình duyệt
WebUI.closeBrowser()
