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

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_ORANGE_DEMO)

'Step 1: Login to the system successfully'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Username'), 'Admin')
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'), 'admin123')
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))

'Verify Dashboard page is loaded successfully'
WebUI.waitForPageLoad(10)

'Verify Check page title and user control displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/p_DashboardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/p_UserControlName'), 10)

'Step 2: '
'Click to the toggle menu button to collapse the menu'
WebUI.click(findTestObject('Object Repository/Dashboard_Page/btn_ToggleMenu'))

'verify the menu will be collapsed completely'
def menu = WebUI.findWebElement(findTestObject('Object Repository/Dashboard_Page/div_OxdBrandBanner'))
String menuStyle = menu.getAttribute("style")
boolean isMenuExpanded = !menuStyle.contains("display: none")
WebUI.verifyEqual(isMenuExpanded, true)

'Verify the toggle button (<) is disappeared'
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/i_ToggleIconRight'), 5)

'Step 3: '
'Click to the toggle menu button to expand  the menu'
WebUI.click(findTestObject('Object Repository/Dashboard_Page/btn_ToggleMenu'))

'verify The menu will be displayed completely'
menuStyle = menu.getAttribute("style")
isMenuExpanded = menuStyle.contains("display: none")
WebUI.verifyEqual(isMenuExpanded, true)

'Verify the un-toggle button (>) is disappeared'
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/i_ToggleIconLeft'), 5)

'Step 4: '
'Type to Search textbox "My Info"'
WebUI.setText(findTestObject('Object Repository/Dashboard_Page/txt_Search'), "My Info")
WebUI.clearText(findTestObject('Object Repository/Dashboard_Page/txt_Search'))
"Verify There's only My Info menu displays'"
List<WebElement> filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/Dashboard_Page/span_MenuItem'), 10)
boolean isOnlyMyInfoDisplayed = true

for (WebElement span : filteredSpans) {
    if (!span.getText().contains("My Info")) {
        isOnlyMyInfoDisplayed = false
        break
    }
}

WebUI.verifyEqual(isOnlyMyInfoDisplayed, true)

'Step 5: '
'Type to Search textbox "D"'
WebUI.setText(findTestObject('Object Repository/Dashboard_Page/txt_Search'), 'D')
filteredSpans = WebUI.findWebElements(findTestObject('Object Repository/Dashboard_Page/span_MenuItem'), 10)
boolean isOnlyDMenusDisplayed = true

for (WebElement span : filteredSpans) {
    if (!span.getText().toLowerCase().contains("d")) { 
        isOnlyDMenusDisplayed = false
        break
    }
}

WebUI.verifyEqual(isOnlyDMenusDisplayed, true)

'Step 6: '
'Click to "Dashboard" menu'
WebUI.click(findTestObject('Object Repository/Dashboard_Page/lnk_Dashboard'))

'Verify Dashboard page is loaded successfully'
WebUI.waitForPageLoad(10)

'Verify page title and user control displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/p_DashboardTitle'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/p_UserControlName'), 10)

'Clean-up steps:'
WebUI.closeBrowser()
