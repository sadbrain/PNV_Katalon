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
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Step 1: Login to the system successfully
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), 'Admin')
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Password'), 'admin123')
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/btn_Login'))

// Verify Dashboard page is loaded successfully
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/lbl_DashboardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/p_UserControlName'), 10)

// Step 2: Collapse the menu
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/btn_ToggleMenu'))

// Verify the menu is collapsed completely
WebElement menu = WebUI.findWebElement(findTestObject('Object Repository/Verify_MainMenu/div_OxdBrandBanner'))
String menuStyle = menu.getAttribute("style")
boolean isMenuCollapsed = menuStyle.contains("display: none")
WebUI.verifyEqual(isMenuCollapsed, true)

// Verify the toggle button (<) is disappeared
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Verify_MainMenu/i_ToggleIconRight'), 5)

// Step 3: Expand the menu
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/btn_ToggleMenu'))

// Verify the menu is displayed completely
menuStyle = menu.getAttribute("style")
boolean isMenuExpanded = !menuStyle.contains("display: none")
WebUI.verifyEqual(isMenuExpanded, true)

// Verify the un-toggle button (>) is disappeared
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Verify_MainMenu/i_ToggleIconLeft'), 5)

// Step 4: Search for "My Info" in the menu
WebUI.setText(findTestObject('Object Repository/Verify_MainMenu/txt_Search'), "My Info")

// Verify only "My Info" menu displays
List<WebElement> filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/Verify_MainMenu/span_MenuItem'), 10)
boolean isOnlyMyInfoDisplayed = true
for (WebElement span : filteredSpans) {
    if (!span.getText().contains("My Info")) {
        isOnlyMyInfoDisplayed = false
        break
    }
}
WebUI.verifyEqual(isOnlyMyInfoDisplayed, true)

// Clear search box for next test
WebUI.clearText(findTestObject('Object Repository/Verify_MainMenu/txt_Search'))

// Step 5: Search for menus containing "D"
WebUI.setText(findTestObject('Object Repository/Verify_MainMenu/txt_Search'), 'D')

// Verify only menus containing "D" are displayed
filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/Verify_MainMenu/span_MenuItem'), 10)
boolean isOnlyDMenusDisplayed = true
for (WebElement span : filteredSpans) {
    if (!span.getText().toLowerCase().contains("d")) {
        isOnlyDMenusDisplayed = false
        break
    }
}
WebUI.verifyEqual(isOnlyDMenusDisplayed, true)

// Clear search box for next test
WebUI.clearText(findTestObject('Object Repository/Verify_MainMenu/txt_Search'))

// Step 6: Click on "Dashboard" menu
WebUI.click(findTestObject('Object Repository/Verify_MainMenu/lnk_Dashboard'))

// Verify Dashboard page is loaded successfully
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/lbl_DashboardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_MainMenu/p_UserControlName'), 10)

// Clean-up steps: Close the browser
WebUI.closeBrowser()