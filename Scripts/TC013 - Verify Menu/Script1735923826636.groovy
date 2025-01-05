import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys


// Step 1: Navigate to the website and click "JQuery UI Menus" link
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/lnk_JQuery'))

// Step 2: Verify the "JQuery UI - Menu" header is displayed
String header1 = WebUI.getText(findTestObject('Object Repository/TC013 - Verify Menu/h3_Header'))
WebUI.verifyEqual(header1, 'JQuery UI Menus', FailureHandling.CONTINUE_ON_FAILURE)

// Step 3: Select "Enabled" -> "JQuery UI menu"
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/ddl_Enabled'))
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/ddl_JQJUI'),  FailureHandling.CONTINUE_ON_FAILURE)

// Verify "JQuery UI" header title is displayed
String header2 = WebUI.getText(findTestObject('Object Repository/TC013 - Verify Menu/h4_Header'))
WebUI.verifyEqual(header2, 'JQuery UI', FailureHandling.CONTINUE_ON_FAILURE)

// Step 4: Click on 'Menu' link
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/lnk_Menu'),FailureHandling.CONTINUE_ON_FAILURE)

// Verify the "JQuery UI - Menu" header is displayed
String header3 = WebUI.getText(findTestObject('Object Repository/TC013 - Verify Menu/h5_Header'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(header3, 'JQuery UI Menus', FailureHandling.CONTINUE_ON_FAILURE)


// Step 5: Select "Enabled" -> "Downloads" -> "CSV menu" and verify the CSV file is downloaded
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/ddl_Enabled'),FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/ddl_Enabled'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC013 - Verify Menu/ddl_Download'), FailureHandling.CONTINUE_ON_FAILURE)

// Verify the CSV file is saved to local (you can use file system verification here)
// Assuming a default download path for verification
def downloadPath = "C:\\Users\\<YourUsername>\\Downloads\\menu.csv"
boolean isFileDownloaded = new File(downloadPath).exists()

// Verify the file is downloaded
WebUI.verifyEqual(isFileDownloaded, true)

// Close browser
WebUI.closeBrowser()

