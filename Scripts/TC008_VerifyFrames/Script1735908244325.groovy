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

WebUI.openBrowser(GlobalVariable.URL)

// Bước 1: Nhấn vào liên kết
WebUI.click(findTestObject('Object Repository/Verify_Frames/lnk_WYSIWYGEditor'))

// Kiểm tra rằng tiêu đề của trang chứa văn bản mong đợi
String actualTitle = WebUI.getText(findTestObject('Object Repository/Verify_Frames/lbl_Title'))
String expectedTitle = 'An iFrame containing the TinyMCE WYSIWYG Editor'
WebUI.verifyEqual(actualTitle.contains(expectedTitle), true)

// Bước 2: Chuyển đến iframe chứa trình chỉnh sửa TinyMCE
// Thay đổi đường dẫn đến iframe
WebUI.switchToFrame(findTestObject('Object Repository/Verify_Frames/fra_TinyMCE'), 10)

// Bước 3: Đặt nội dung mới trong trình chỉnh sửa
WebUI.setText(findTestObject('Object Repository/Verify_Frames/txt_TinyMCE'), "Hello, how are you?")

// Bước 4: Kiểm tra nội dung bên trong trình chỉnh sửa đã được cập nhật
String actualUpdatedContent = WebUI.getText(findTestObject('Object Repository/Verify_Frames/txt_TinyMCE'))
String expectedUpdatedContent = 'Hello, how are you?'
WebUI.verifyEqual(actualUpdatedContent, expectedUpdatedContent)

// Bước 5: Chuyển trở lại trang chính và đóng trình duyệt
WebUI.switchToDefaultContent()
WebUI.closeBrowser()