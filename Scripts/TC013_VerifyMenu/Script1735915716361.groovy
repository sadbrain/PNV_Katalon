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


// Step 1 : Go to https://the-internet.herokuapp.com/
WebUI.openBrowser(GlobalVariable.MENU_URL)

// Select 'JQuery UI Menus' link
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_JQueryUIMenus'))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/JQueryUIMenus_Page/lbl_JQueryUIMenuTitle')), "JQueryUI - Menu")

// Hover to display menu
WebUI.mouseOver(findTestObject('Object Repository/JQueryUIMenus_Page/btn_MenuDropdown'))

// Step 2: Select Enabled -> JQuery UI menu
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/btn_BackToQueryUI'))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/JQueryUIMenus_Page/lbl_JQueryUIMenuTitle')), "JQuery UI")

// Step 3 : Click on 'Menu' link
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_Menu'))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/JQueryUIMenus_Page/lbl_JQueryUIMenuTitle')), "JQueryUI - Menu")

// Step : Select Enabled -> Downloads -> CSV menu
WebUI.mouseOver(findTestObject('Object Repository/JQueryUIMenus_Page/btn_MenuDropdown'))
WebUI.mouseOver(findTestObject('Object Repository/JQueryUIMenus_Page/btn_Download'))
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/btn_DownloadCSV'))

// Verify that the menu.csv file is saved to local successful
String filePath = "C:\\Users\\binh\\Downloads\\menu.csv"

File file = new File(filePath)
print(" File name "+ file.name)

WebUI.delay(4)

if (file.exists()){
	println("The menu.csv file is saved to local successful")
	WebUI.verifyMatch(file.name, "menu.csv", false)
	
} else {
	WebUI.verifyNotMatch(file.name, "menu1.csv", false)
}

WebUI.closeBrowser()