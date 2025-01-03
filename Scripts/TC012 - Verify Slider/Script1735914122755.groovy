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


// Step 1: Mở trình duyệt và điều hướng đến trang web
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/TC012 - Verify Slider/lnk_HorizontalSlider'))


// Step 2 : Set Slider to 1
String script1 = "document.querySelector('input[type=range]').value = '1'; document.querySelector('input[type=range]').dispatchEvent(new Event('change'));"
WebUI.executeJavaScript(script1, null)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/TC012 - Verify Slider/SliderValue')), '1', false)

// Step 3 : Set Slider to 2.5
String script2 = "document.querySelector('input[type=range]').value = '2.5'; document.querySelector('input[type=range]').dispatchEvent(new Event('change'));"
WebUI.executeJavaScript(script2, null)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/TC012 - Verify Slider/SliderValue') ), '2.5', false)

// Step 4 : Set Slider to 4.5
String script3 = "document.querySelector('input[type=range]').value = '4.5'; document.querySelector('input[type=range]').dispatchEvent(new Event('change'));"
WebUI.executeJavaScript(script3, null)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/TC012 - Verify Slider/SliderValue')), '4.5', false)

WebUI.closeBrowser()
