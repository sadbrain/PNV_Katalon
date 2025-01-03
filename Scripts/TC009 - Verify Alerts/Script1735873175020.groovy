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
WebUI.navigateToUrl('https://the-internet.herokuapp.com/javascript_alerts')

' Step 2: Verify the header is JavaScript Alerts'
WebUI.verifyTextPresent('JavaScript Alerts', false)

'Step 3 Click on the JsAlert btn and click on OK on dialog'
WebUI.click(findTestObject('Object Repository/009 - Verify Alerts/btn_JsAlert') )
WebUI.acceptAlert()

'Step 4 Click on the JsConfirm btn and click on Cancel on dialog'
WebUI.click(findTestObject('Object Repository/009 - Verify Alerts/btn_JsConfirm') )
WebUI.dismissAlert()
 
'Step 5 Click on the JsPrompt btn and add "Hello" text on dialog'
WebUI.click(findTestObject('Object Repository/009 - Verify Alerts/btn_JsPrompt') )
'Input text on the alert'
WebUI.setAlertText('Hello')

WebUI.closeBrowser()



