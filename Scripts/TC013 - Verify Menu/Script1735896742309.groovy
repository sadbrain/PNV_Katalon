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

' Step 1: Open browser and navigate to URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/jqueryui/menu')

'Step 2: Verify the header is JQueryUI - Menur'
WebUI.verifyTextPresent('JQueryUI - Menu', false)

'Step 3: Click on Enabled and choose Back to JQuery UI'
WebUI.click( findTestObject('Object Repository/013 - Verify Menu/ddl_Enabled'))
WebUI.click(findTestObject('Object Repository/013 - Verify Menu/option_BackToJQueryUI') )
WebUI.verifyTextPresent('JQuery UI', false)

'Step 4: Click on Menu link'
WebUI.click( findTestObject('Object Repository/013 - Verify Menu/txt_MenuLink'))
WebUI.verifyTextPresent('JQueryUI - Menu', false)

'Step 5: Click on Enabled, choose Download and choose CSV'
WebUI.click( findTestObject('Object Repository/013 - Verify Menu/ddl_Enabled'))
WebUI.click( findTestObject('Object Repository/013 - Verify Menu/ddl_Download'))
WebUI.click( findTestObject('Object Repository/013 - Verify Menu/option_CSV'))