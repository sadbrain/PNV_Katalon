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

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Click the "WYSIWYG Editor" link'
WebUI.click(findTestObject('Object Repository/Frames_Page/lnk_WYSIWYGEditor'))

'Verify the "An iFrame containing the TinyMCE WYSIWYG Editor" title is displayed on the page'
WebUI.verifyTextPresent('An iFrame containing the TinyMCE WYSIWYG Editor', false)

'Close any pop-up or modal by clicking the "Close" button'
WebUI.click(findTestObject('Object Repository/Frames_Page/btn_Close'))

'Switch to the iframe that contains the WYSIWYG Editor'
WebUI.switchToFrame(findTestObject('Object Repository/Frames_Page/frm_tinymceEditor'), 10)

'Identify the body element of the WYSIWYG Editor'
TestObject editorBody = findTestObject('Object Repository/Frames_Page/txt_Content')

'Verify the default content'
String defaultContent = WebUI.getText(editorBody)
WebUI.verifyMatch(defaultContent, 'Your content goes here.', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.comment("The default content body is 'Your content goes here.'")

'Update the content'
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = (JavascriptExecutor) driver
js.executeScript("arguments[0].innerHTML = 'Hello, how are you?'", WebUI.findWebElement(editorBody))

'Verify the updated content'
String newContent = WebUI.getText(editorBody)
WebUI.verifyMatch(newContent, 'Hello, how are you?', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.comment("The content body is 'Hello, how are you?'")

'Exit the iframe'
WebUI.switchToDefaultContent()

'Close browser'
WebUI.closeBrowser()



