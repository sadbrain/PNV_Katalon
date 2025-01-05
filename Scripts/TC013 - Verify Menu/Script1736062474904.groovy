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

// step 1: Open the browser and navigate to the URL
WebUI.openBrowser(GlobalVariable.URL_HERROKUAPP)
WebUI.click(findTestObject('Object Repository/JQueryUIMenu_Page/lnk_JQueryMenu') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText( findTestObject('Object Repository/JQueryUIMenu_Page/h3_HeaderTitleMenu'), 'JQueryUI - Menu', FailureHandling.CONTINUE_ON_FAILURE)

// step 2: Select Enabled -> JQuery UI menu
WebUI.click(findTestObject('Object Repository/JQueryUIMenu_Page/mnu_Enabled'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/JQueryUIMenu_Page/mnu_JQuery'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/JQueryUIMenu_Page/h3_JQueryUI'), 'JQuery UI', FailureHandling.CONTINUE_ON_FAILURE)

// step 3: Click on 'Menu' link
WebUI.click( findTestObject('Object Repository/JQueryUIMenu_Page/lnk_Menu'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText( findTestObject('Object Repository/JQueryUIMenu_Page/h3_HeaderTitleMenu'), 'JQueryUI - Menu', FailureHandling.CONTINUE_ON_FAILURE)

// step 4: Select Enabled -> Downloads -> CSV menu
WebUI.click(findTestObject('Object Repository/JQueryUIMenu_Page/mnu_Enabled'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/JQueryUIMenu_Page/mnu_Download'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click( findTestObject('Object Repository/JQueryUIMenu_Page/mnu_CSV'), FailureHandling.CONTINUE_ON_FAILURE)

// Verify that the menu.csv file is saved to local successful
String filePath = "C:\\Users\\XUOM\\Downloads\\menu.csv"

File file = new File(filePath)
print(" File name "+ file.name)

WebUI.delay(4)

if (file.exists()) {
	WebUI.verifyMatch(file.name, "menu.csv", false)
	println("The menu.csv file is saved to local successful")
} else {
	WebUI.verifyNotMatch(file.name, "menu.csv", false)
	println("Tệp menu.csv không được tải xuống.")

}

// Close Browser
WebUI.closeBrowser()