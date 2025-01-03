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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Step 1: Open Browser
WebUI.openBrowser('')

// Step 2: Navigate to the URL
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

// Step 3: Click on the 'WYSIWYG Editor' link
WebUI.click(findTestObject('Object Repository/TC008 - Verify Frames/lnk_Frames'))


'Verify that the title of the page contains the expected text'
String pageTitle = WebUI.getText(findTestObject('Object Repository/TC008 - Verify Frames/NewTest'))
WebUI.verifyMatch(pageTitle, 'An iFrame containing the TinyMCE WYSIWYG Editor', false, FailureHandling.OPTIONAL)


'Step 2: '
'Switch to the iframe containing the TinyMCE editor'
WebUI.switchToFrame(findTestObject('Object Repository/TC008 - Verify Frames/Iframe'), 10)

'Step 4: '
'Verify the default content inside the editor'
String actualDefaultContent = WebUI.getText(findTestObject('Object Repository/TinyMCE_Page/txt_Content'))
String expectedDefaultContent = 'Your content goes here.'
WebUI.verifyEqual(actualDefaultContent, expectedDefaultContent)

'Step 5: '
'Switch back to the main page and close the browser'
WebUI.switchToDefaultContent()

'Clean-up steps:'
WebUI.closeBrowser()


// Lấy nội dung văn bản của trình soạn thảo

String defaultContent = WebUI.getText(findTestObject('Object Repository/TC008 - Verify Frames/NewTest'))
println(defaultContent)

// Xác minh nội dung mặc định là "Your content goes here."
//WebUI.verifyEqual(defaultContent, 'Your content goes here.', false)
WebUI.verifyEqual(defaultContent, "An iFrame containing the TinyMCE WYSIWYG Editor")

WebUI.click(findTestObject('Object Repository/TC008 - Verify Frames/btnClose'))

//WebUI.switchToFrame(findTestObject('Object Repository/TC008 - Verify Frames/Iframe'), 10)

//WebUI.waitForElementVisible(findTestObject('Object Repository/TC008 - Verify Frames/txt_Content'), 10)
String text = WebUI.getText(findTestObject('Object Repository/TC008 - Verify Frames/txt_Content'), 10)
 println("Your text: " , text)

WebUI.verifyEqual(text, "Your content goes here.")


// Step 6: Set new content "Hello, how are you?"
//WebUI.setText(findTestObject('Object Repository/TC008 - Verify Frames/txt_Content'), 'Hello, how are you?')

// Step 7: Verify the content is updated
//String newContent = WebUI.getText(findTestObject('Object Repository/TC008 - Verify Frames/body_EditorContent'))
//WebUI.verifyMatch(newContent, 'Hello, how are you?', false)

// Step 8: Switch back to the main content
WebUI.switchToDefaultContent()

// Step 9: Close the browser
WebUI.closeBrowser()

