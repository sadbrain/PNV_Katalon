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

// Pre-condition steps:
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'Step 1: '
'Click on the "WYSIWYG Editor" link'
WebUI.click(findTestObject('Object Repository/TinyMCE_Page/lnk_WYSIWYGEditor'))

'Verify that the title of the page contains the expected text'
String actualTitle = WebUI.getText(findTestObject('Object Repository/TinyMCE_Page/h3_Title'))
String expectedTitle = 'An iFrame containing the TinyMCE WYSIWYG Editor'
WebUI.verifyTextPresent(actualTitle.contains(expectedTitle), false)

// Step 2: '
'Switch to the iframe containing the TinyMCE editor'
WebUI.switchToFrame(findTestObject('Object Repository/TinyMCE_Page/iframe_TinyMCEEditor'), 10)

'Step 3: '
'Set new content in the editor to "Hello, how are you?"'
WebUI.setText(findTestObject('Object Repository/TinyMCE_Page/txt_Content'), "Hello, how are you?")

'Step 4: '
'Verify the content inside the editor has been updated'
String actualUpdatedContent = WebUI.getText(findTestObject('Object Repository/TinyMCE_Page/txt_Content'))
String expectedUpdatedContent = 'Hello, how are you?'
WebUI.verifyEqual(actualUpdatedContent, expectedUpdatedContent)

// Step 5: '
'Switch back to the main page and close the browser'
WebUI.switchToDefaultContent()

// Clean-up steps:
WebUI.closeBrowser()
