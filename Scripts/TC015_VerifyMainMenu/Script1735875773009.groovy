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

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_LOGIN)

'Get username text from Login form to enter into Username textbox'
WebUI.setText(findTestObject('Object Repository/MainMenu_Page/txt_UserName'), 'Admin')
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/MainMenu_Page/txt_UserName'), 'value'), 'Admin', false)

'Get password text from Login form to enter into Password textbox'
WebUI.setText(findTestObject('Object Repository/MainMenu_Page/txt_Password'), 'admin123')
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/MainMenu_Page/txt_Password'), 'value'), 'admin123', false)

'Click Login button'
WebUI.click(findTestObject('Object Repository/MainMenu_Page/btn_Login'))

WebUI.waitForPageLoad(5)

'Click the button to open the menu'
WebUI.click(findTestObject('Object Repository/MainMenu_Page/btn_ToggleMenu'))
WebUI.click(findTestObject('Object Repository/MainMenu_Page/btn_UnToggle'))

WebUI.setText(findTestObject('Object Repository/MainMenu_Page/txt_Search'), "My Info")

'// Verify menu is filtered correctly with "My Info"'
List<WebElement> filteredMenus = WebUI.findWebElements(findTestObject('Object Repository/MainMenu_Page/span_MyMenu'), 10)
boolean isMyInfoDisplayed = true
for (WebElement menu : filteredMenus) {
    if (menu.getText() == null || !menu.getText().contains("My Info")) {
        isMyInfoDisplayed = false
        break
    }
}
WebUI.verifyEqual(isMyInfoDisplayed, true)

WebUI.clearText(findTestObject('Object Repository/MainMenu_Page/txt_Search'))

WebUI.setText(findTestObject('Object Repository/MainMenu_Page/txt_Search'), "D")

'Verify that only menus containing the letter "d" are displayed'
filteredMenus = WebUI.findWebElements(findTestObject('Object Repository/MainMenu_Page/span_MyMenu'), 10)
boolean isDMenuDisplayed = true
for (WebElement menu : filteredMenus) {
    if (!menu.getText().toLowerCase().contains("d")) {
        isDMenuDisplayed = false
        break
    }
}
WebUI.verifyEqual(isDMenuDisplayed, true)

'Click to "Dashboard" menu'
WebUI.click(findTestObject('Object Repository/MainMenu_Page/lnk_Dasboard'))
WebUI.waitForPageLoad(5)

'Verify page title and user control are displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/LoginFunction_Page/p_DashboardTitle'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/LoginFunction_Page/ddl_UserControl'), 5)

'Close browser'
WebUI.closeBrowser()