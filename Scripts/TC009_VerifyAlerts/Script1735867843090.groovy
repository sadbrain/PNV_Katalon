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
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.Alert

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.URL)

// Click 'JavaScript Alerts' link
WebUI.click(findTestObject('Object Repository/Verify_Alerts/lnk_JavaScriptAlerts'))

// Verify header title of JavaScript Alerts page
String pageTitle = WebUI.getText(findTestObject('Object Repository/Verify_Alerts/lb_HeaderTitle'))

// So sánh với giá trị mong đợi
assert pageTitle == 'JavaScript Alerts' : "Page title is incorrect! Actual title: " + pageTitle

// Check JS Alert
WebUI.click(findTestObject('Object Repository/Verify_Alerts/btn_JSAlert'))
WebDriver driver = DriverFactory.getWebDriver()
Alert alert = driver.switchTo().alert()
assert alert.getText() == "I am a JS Alert" : "Alert text is incorrect!!"
alert.accept()

// Check result after click JS Alert
WebUI.verifyTextPresent('You successfully clicked an alert', false)

// Check JS Confirm
WebUI.click(findTestObject('Object Repository/Verify_Alerts/btn_JSConfirm'))
alert = driver.switchTo().alert()
assert alert.getText() == "I am a JS Confirm" : "Alert text is incorrect!"
alert.dismiss()

// Check result after click Cancel on JS Confirm
WebUI.verifyTextPresent('You clicked: Cancel', false)

// Check JS Prompt
WebUI.click(findTestObject('Object Repository/Verify_Alerts/btn_JSPrompt'))
alert = driver.switchTo().alert()
alert.sendKeys("Hello")
alert.accept()

//Check result after enter "Hello" on JS Prompt
WebUI.verifyTextPresent('You entered: Hello', false)




