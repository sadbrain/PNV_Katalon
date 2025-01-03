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
'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'step 1: '
'Navigate to JQuery UI Menus page'
WebUI.click(findTestObject('Object Repository/Heroku_Page/lnk_JQueryUIMenu'))

'Verify that "JQueryUI - Menu" header title is displayed'
WebUI.verifyTextPresent("JQueryUI - Menu", false)

'step 2: '
'Hover over and click "Enabled" menu item'
WebUI.mouseOver(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Enabled'))
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Enabled'))

'Hover over and click "JQuery UI menu" menu item'
WebUI.mouseOver(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_JQueryUI'))
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_JQueryUI'))

'verify JQuery UI header title is displayed and back to JQueryUI - Menu URL'
WebUI.verifyTextPresent("JQuery UI", false)
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/lnk_Menu'))

'step 3: '
'Hover over and click "Enabled" menu item'
WebUI.mouseOver(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Enabled'))
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Enabled'))

'Hover over and click "Downloads" submenu'
WebUI.mouseOver(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Downloads'))
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Downloads'))

'Click "CSV" menu item and verify download'
'Hover over and click "Enabled" menu item'
WebUI.mouseOver(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_CSV'))
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_CSV'))

'Verify the file is downloaded successfully'
File downloadsDir = new File("C:\\Users\\admin\\Downloads")
boolean fileExists = downloadsDir.listFiles().any { it.name.endsWith("menu.csv") }
assert fileExists : "CSV file not downloaded!"

'Clean-up steps:'
WebUI.closeBrowser()