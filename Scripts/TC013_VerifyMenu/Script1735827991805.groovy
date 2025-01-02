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

'Step 1: '
'Navigate to javaScript Alerts page'
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/lnk_JQueryUIMenu'))

'Step 2: '
'Verify that "JQueryUI - Menu" header title is displayed'
WebUI.verifyTextPresent(("JQueryUI - Menu"), false)

'Step 3: '
'Click on the "Enabled" menu item in the JQuery UI menu'
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Enabled'))

'Step 4: '
'Click on the JQuery UI menu'
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_JQueryUI'))

'Step 5: '
'Verify that "JQuery UI" header title is displayed'
WebUI.verifyTextPresent(("JQuery UI"), false)

'Step 6: '
'Back to the previous page'
WebUI.back()

'Step 7: '
'Click on the "Enabled" menu item in the JQuery UI menu'
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Enabled'))

'Step 8: '
'Click on the "Downloads" menu item in the JQuery UI menu'
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_Downloads'))

'Step 9: '
'Click on the "CSV" menu item in the JQuery UI menu'
WebUI.click(findTestObject('Object Repository/JQueryUI_Menu_Page/mnu_CSV'))

