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
import java.nio.file.Files

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Verify the presence of JQuery UI Menus link and click on it'
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_JQueryUIMenus'))

'Verify that the JQueryUI - Menu header title is displayed'
WebUI.verifyTextPresent('JQueryUI - Menu', false)

'Click on the Enabled menu and verify'
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_Enabled'))
WebUI.verifyTextPresent('JQueryUI', false)

'Click on the JQueryUI menu and verify'
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_JQueryUI'))
WebUI.verifyTextPresent('JQuery UI', false)

'Click on the Menu and verify'
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_Menu'))
WebUI.verifyTextPresent('JQueryUI - Menu', false)

'Click on the Downloads'
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_Enabled'))
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_Download'))
WebUI.click(findTestObject('Object Repository/JQueryUIMenus_Page/lnk_CSV'))

'Verify the CSV file is downloaded'
String downloadPath = file
File file = new File(downloadPath)

'Close browser'
WebUI.closeBrowser()



