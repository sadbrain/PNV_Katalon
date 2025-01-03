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

// Step 1 : Go to https://the-internet.herokuapp.com/
WebUI.openBrowser(GlobalVariable.MENU_URL)

// Select 'WYSIWYG Editor' link
WebUI.click(findTestObject('Object Repository/Frames_Page/lnk_WYSIWYGEditor'))

// Verify title 'An iFrame containing the TinyMCE WYSIWYG Editor title is displayed'
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Frames_Page/lbl_WYSIWYGEditorTitle')), "An iFrame containing the TinyMCE WYSIWYG Editor")

// swich to frame 
WebUI.switchToFrame(findTestObject('Object Repository/Frames_Page/frame_Editor'), 10)

// Step 2 : Verify the default content
String contentDefault = WebUI.getText(findTestObject('Object Repository/Frames_Page/txa_Content'))
WebUI.verifyEqual( contentDefault, "Your content goes here.")

WebUI.closeBrowser()