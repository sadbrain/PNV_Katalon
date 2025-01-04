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
// Step 1: Login to the system successfully
WebUI.openBrowser(GlobalVariable.URL_ORANGE)
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_UserName'),'Admin' )
WebUI.setEncryptedText(findTestObject('Object Repository/Login_Page/txt_Password'), "hUKwJTbofgPU9eVlw/CnDQ==")
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))
WebUI.waitForPageLoad(10)

// 'Verify Check page title and user control displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Login_Page/h6_PageTitle') , 'Dashboard', FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 0)

// Step 2 : Click to the toggle menu button to collapse the menu
WebUI.click(findTestObject('Object Repository/Dashboard_Page/btn_Toggle'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/btn_ToggleRight'), 2)
// Verify that the menu will be collapsed completely
String sibarCollapsed  = WebUI.getAttribute(findTestObject('Object Repository/Dashboard_Page/aside_SideBar'), 'class')
WebUI.verifyEqual(sibarCollapsed , "oxd-sidepanel toggled")

// Step 3  : Click to the un-toggle menu button to open the menu
WebUI.click(findTestObject('Object Repository/Dashboard_Page/btn_Toggle'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard_Page/btn_ToggleLeft') , 2)

// Verify that the menu will be collapsed completely
WebUI.delay(4)
String sibarDisplayed  = WebUI.getAttribute(findTestObject('Object Repository/Dashboard_Page/aside_SideBar'), 'class')
print("---" + sibarDisplayed )
WebUI.verifyEqual(sibarDisplayed , "oxd-sidepanel")

// Step 4 : Type to Search textbox "My Info"
WebUI.setText(findTestObject('Object Repository/Dashboard_Page/txt_Search'), "My Info")
// verify that there's only My Info menu displays
TestObject testObj = findTestObject('Object Repository/Dashboard_Page/span_MenuItem')
List <WebElement> elementsMyInfo = WebUI.findWebElements(testObj, 20)

// Clear text
WebUI.click(findTestObject('Object Repository/Dashboard_Page/txt_Search'))
WebUI.sendKeys(findTestObject('Object Repository/Dashboard_Page/txt_Search'), Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE))
// Step 5 : Type to Search textbox "D"
WebUI.setText(findTestObject('Object Repository/Dashboard_Page/txt_Search'), "D")
List <WebElement> elementContainD = WebUI.findWebElements(testObj, 20)
boolean containsD = false
for (item in elementContainD) {
	if(item.getText().toLowerCase().contains("d")) {
		containsD = true;
	}
}
WebUI.verifyEqual(containsD, true)
// Step 6 : Click to "Dashboard" menu
WebUI.click(findTestObject('Object Repository/Dashboard_Page/mnu_MenuDefaultItem'))
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Dashboard')), 'Dashboard')
WebUI.closeBrowser()