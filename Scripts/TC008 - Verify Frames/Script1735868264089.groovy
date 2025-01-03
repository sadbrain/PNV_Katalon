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

'Step 1'
'Open the browser and navigate to the URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/tinymce')

'Step 2'

'Retrieve and verify the header text'
String actualHeaderText = WebUI.getText(findTestObject('Object Repository/TC008 - Verify Frames/h3_Title'))
WebUI.comment('Actual Header Text: ' + actualHeaderText)
WebUI.verifyMatch(actualHeaderText.trim(), 'An iFrame containing the TinyMCE WYSIWYG Editor', false)
'Step 3: '
'Verify the default content inside the editor'
String actualDefaultContent = WebUI.getText(findTestObject('Object Repository/TC008 - Verify Frames/txt_Your content goes here'))
String expectedDefaultContent = 'Your content goes here.'
WebUI.verifyEqual(actualDefaultContent, expectedDefaultContent)
'Step 4: '
'Switch back to the main page and close the browser'
WebUI.switchToDefaultContent()

WebUI.closeBrowser()