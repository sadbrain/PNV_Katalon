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
WebUI.setText(findTestObject('Object Repository/TC014 - Verify Login Function/txt_UserName'), 'Admin')
WebUI.setText(findTestObject('Object Repository/TC014 - Verify Login Function/txt_Password'), 'admin123')
WebUI.click(findTestObject('Object Repository/TC014 - Verify Login Function/btn_Login'))

// Verify Dashboard page is loaded successfully
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('Object Repository/TC014 - Verify Login Function/p_DashBoardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/TC014 - Verify Login Function/p_UserControlName'), 10)

// Step 2: Collapse the menu
WebUI.click(findTestObject('Object Repository/TC015 - Verify main menu/btn_ToggleMenu'))

// Wait for the menu to collapse
WebUI.delay(2) // Allow time for UI changes

// Check menu's style attribute for visibility state
WebElement menu = WebUI.findWebElement(findTestObject('Object Repository/TC015 - Verify main menu/mnu_FileOpen'))
String menuStyle = menu?.getAttribute("style") // Null-safe

if (menuStyle == null || menuStyle.isEmpty()) {
    WebUI.comment("Menu style attribute is missing or not accessible")
} else {
    boolean isMenuCollapsed = menuStyle.contains("display: none") // Adjust this condition based on actual implementation
    println("Menu is Collapsed: " + isMenuCollapsed)
    WebUI.verifyEqual(isMenuCollapsed, true)
}

// Verify the toggle button (<) is disappeared
WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC015 - Verify main menu/ic_RightToggle'), 5)

// Step 3: Expand the menu
WebUI.click(findTestObject('Object Repository/TC015 - Verify main menu/btn_ToggleMenu'))

// Wait for menu to expand
WebUI.delay(2)

// Verify the menu is displayed completely
menuStyle = menu?.getAttribute("style")

boolean isMenuExpanded = menuStyle != null && !menuStyle.contains("display: none")
println("Menu is Expanded: " + isMenuExpanded)
WebUI.verifyEqual(isMenuExpanded, true)

// Verify the un-toggle button (>) is disappeared
WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC015 - Verify main menu/ic_LeftToggle'), 5)

// Step 4: Search for "My Info" in the menu
WebUI.setText(findTestObject('Object Repository/TC015 - Verify main menu/txt_Search'), "My Info")

// Verify only "My Info" menu displays
List<WebElement> filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/TC015 - Verify main menu/span_MyMenu'), 10)
boolean isOnlyMyInfoDisplayed = filteredSpans.every { span -> span.getText().contains("My Info") }

WebUI.verifyEqual(isOnlyMyInfoDisplayed, true)

// Clear search box for next test
WebUI.clearText(findTestObject('Object Repository/TC015 - Verify main menu/txt_Search'))

// Step 5: Search for menus containing "D"
WebUI.setText(findTestObject('Object Repository/TC015 - Verify main menu/txt_Search'), 'D')

// Verify only menus containing "D" are displayed
filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/TC015 - Verify main menu/span_MyMenu'), 10)
boolean isOnlyDMenusDisplayed = filteredSpans.every { span -> span.getText().toLowerCase().contains("d") }

WebUI.verifyEqual(isOnlyDMenusDisplayed, true)

// Clear search box for next test
WebUI.clearText(findTestObject('Object Repository/TC015 - Verify main menu/txt_Search'))

// Step 6: Click on "Dashboard" menu
WebUI.click(findTestObject('Object Repository/TC015 - Verify main menu/lnk_DashBoard'))

// Verify Dashboard page is loaded successfully
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('Object Repository/TC014 - Verify Login Function/p_DashBoardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/TC014 - Verify Login Function/p_UserControlName'), 10)

// Clean-up steps: Close the browser
WebUI.closeBrowser()
