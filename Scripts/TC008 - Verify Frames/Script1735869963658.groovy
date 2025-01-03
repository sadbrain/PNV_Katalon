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

'Step 1: Open browser and navigate to URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/tinymce')

'Step 2: Verify the header'
WebUI.click(findTestObject('Object Repository/008 - Verify Frames/btn_Cancel'))
WebUI.verifyTextPresent('An iFrame containing the TinyMCE WYSIWYG Editor', false)

'Step 3: Switch to the iframe and verify the default content'
WebUI.verifyTextPresent('Your content goes here.', false)
'Step 4: Set text and verify'
WebUI.setText(findTestObject('Object Repository/008 - Verify Frames/txt_DefaultContentBody'), 'Hello, how are you?')
WebUI.verifyTextPresent('Hello, how are you?', false)

'Step 5: Switch back to the main content'
WebUI.switchToDefaultContent()

WebUI.closeBrowser()
