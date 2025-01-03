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


"Step 1"
"JavaScript Alerts header title is displayed"
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/javascript_alerts')
WebUI.verifyTextPresent('JavaScript Alerts', false)

"Step 2"
'Clicking on  button Click for JS Alert'
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/btn_Click for JS Alert'))


'Accepting the Alert'
WebUI.acceptAlert()
WebUI.verifyTextPresent('You successfully clicked an alert', false)

"Step 3"
"Clicking on button I am a JS Confirm"
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/btn_I am a JS Confirm'))
'Dismiss the Alert '
WebUI.dismissAlert()
WebUI.verifyTextPresent('You clicked: Cancel', false)

"Step 4"
"Clicking button Click for JS Prompt"
WebUI.click(findTestObject('Object Repository/TC009 - Verify Alerts/btn_Click for JS Prompt'))

WebUI.setAlertText('Hello')

WebUI.closeBrowser()





