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
import java.nio.file.Files
import java.nio.file.Paths

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_JQueryUIMenus'))

// Verify Header Title only once after navigation
WebUI.verifyElementText(findTestObject('Object Repository/Verify_Menu/lbl_HeaderTitle'), 'JQueryUI - Menu')

// Interact with Menu
WebUI.mouseOver(findTestObject('Object Repository/Verify_Menu/lnk_Enabled'))
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_JQueryUIMenu'))
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_Menu'))

// Select Downloads -> CSV menu
WebUI.mouseOver(findTestObject('Object Repository/Verify_Menu/lnk_Enabled'))
WebUI.mouseOver(findTestObject('Object Repository/Verify_Menu/lnk_Downloads'))
WebUI.click(findTestObject('Object Repository/Verify_Menu/lnk_CSV'))

// Verify the file is downloaded
String downloadPath = System.getProperty('user.home') + '/Downloads/menu.csv'
boolean isFileDownloaded = false

// Wait longer before checking for the file
WebUI.delay(5) // Increased wait time
isFileDownloaded = Files.exists(Paths.get(downloadPath))

// Verify the download status
WebUI.verifyEqual(isFileDownloaded, true)



