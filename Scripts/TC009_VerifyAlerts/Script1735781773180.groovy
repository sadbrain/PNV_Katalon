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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Alert

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Click on the "JavaScript Alerts" link'
WebUI.click(findTestObject('Object Repository/Alerts_Page/lnk_JavaScriptAlerts'))

'Verify that the "JavaScript Alerts" header title is displayed'
WebUI.verifyTextPresent('JavaScript Alerts', false)

'Get WebDriver instance'
WebDriver driver = DriverFactory.getWebDriver()

'Handle "Click for JS Alert" button'
WebUI.click(findTestObject('Object Repository/Alerts_Page/btn_JSAlert'))
Alert alert = driver.switchTo().alert()
String alertMessage = alert.getText()
WebUI.verifyMatch(alertMessage, 'I am a JS Alert', false)
alert.accept()
WebUI.verifyTextPresent('You successfully clicked an alert', false)

'Handle "Click for JS Confirm" button'
WebUI.click(findTestObject('Object Repository/Alerts_Page/btn_JSConfirm')) 
alert = driver.switchTo().alert()
alert.dismiss()
WebUI.verifyTextPresent('You clicked: Cancel', false)

'Handle "Click for JS Prompt" button'
WebUI.click(findTestObject('Object Repository/Alerts_Page/btn_JSPrompt'))
alert = driver.switchTo().alert()
alert.sendKeys('Hello')
alert.accept()
WebUI.verifyTextPresent('You entered: Hello', false)

'Close browser'
WebUI.closeBrowser()