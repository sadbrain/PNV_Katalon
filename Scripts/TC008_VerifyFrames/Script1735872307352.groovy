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
'Click on the "WYSIWYG Editor" link'
WebUI.click(findTestObject('Object Repository/Heroku_Page/lnk_WYSIWYGEditor'))

'Verify that the title of the page contains the expected text'
WebUI.verifyTextPresent(WebUI.getText(findTestObject('Object Repository/TinyMCE_Page/h3_Title')), false)

'Step 2: '
'Switch to the iframe containing the TinyMCE editor'
WebUI.switchToFrame(findTestObject('Object Repository/TinyMCE_Page/iframe_TinyMCEEditor'), 10)

'Step 3: '
'Verify the default content inside the editor'
String actualDefaultContent = WebUI.getText(findTestObject('Object Repository/TinyMCE_Page/txt_Content'))
String expectedDefaultContent = 'Your content goes here.'
WebUI.verifyEqual(actualDefaultContent, expectedDefaultContent)

'Step 4: '
'Switch back to the main page and close the browser'
WebUI.switchToDefaultContent()

'Clean-up steps:'
WebUI.closeBrowser()