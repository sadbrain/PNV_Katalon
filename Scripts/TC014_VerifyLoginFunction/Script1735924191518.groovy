import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Mở trình duyệt và điều hướng
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Lấy và điền Username
String userName = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Username')).split(":")[1].trim()
WebUI.verifyEqual(userName, "Admin")
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Username'), userName)

// Lấy và điền Password
String password = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Password')).split(":")[1].trim()
WebUI.verifyEqual(password, "admin123")
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'), password)

// Click Login và kiểm tra Dashboard
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))
WebUI.waitForPageLoad(10)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Login_Page/p_DashboardTitle')), "Dashboard", false)

// Kiểm tra User Control hiển thị và thực hiện Logout
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)
WebUI.click(findTestObject('Object Repository/Login_Page/p_UserControlName'))
WebUI.click(findTestObject('Object Repository/Login_Page/ddl_Logout'))

// Kiểm tra quay lại trang Login
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/p_LoginTitle'), 10)
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

// Đóng trình duyệt
WebUI.closeBrowser()
