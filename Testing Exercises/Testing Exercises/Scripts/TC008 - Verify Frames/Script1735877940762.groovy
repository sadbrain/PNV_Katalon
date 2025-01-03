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

// step 1: Go to https://the-internet.herokuapp.com/ and Select 'WYSIWYG Editor' link
WebUI.openBrowser(GlobalVariable.URL_HERROKUAPP, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click( findTestObject('Object Repository/Editor_Page/lnk_WYSIWYGEditor'), FailureHandling.CONTINUE_ON_FAILURE)

// Verify tile An iFrame containing the TinyMCE WYSIWYG Editor is displayed
WebUI.verifyTextPresent('An iFrame containing the TinyMCE WYSIWYG Editor', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/Editor_Page/h3_HeaderTitle'), 'An iFrame containing the TinyMCE WYSIWYG Editor')

// Switch to the iframe containing the TinyMCE editor'
WebUI.switchToFrame(findTestObject('Object Repository/Editor_Page/iframe_TinyMCEEditor'), 10)

// step 2: Verify the default content
String actualDefaultContent = WebUI.getText( findTestObject('Object Repository/Editor_Page/txt_Content'), FailureHandling.CONTINUE_ON_FAILURE)
