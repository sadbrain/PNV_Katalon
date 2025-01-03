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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://the-internet.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/Page_VerifyKeyPresses/lnk_KeyPress'))

// Presses TAB
WebUI.sendKeys(findTestObject('Object Repository/Page_VerifyKeyPresses/txt_Field'), Keys.chord(Keys.TAB))
WebUI.verifyTextPresent('You entered: TAB', false)
// Presses ENTER
WebUI.sendKeys(findTestObject('Object Repository/Page_VerifyKeyPresses/txt_Field'), Keys.chord(Keys.ENTER))
// Presses G
WebUI.sendKeys(findTestObject('Object Repository/Page_VerifyKeyPresses/txt_Field'), 'G')
WebUI.verifyTextPresent('You entered: G', false)

String message = WebUI.getText(findTestObject('Object Repository/Page_VerifyKeyPresses/Message_Notification'))
WebUI.verifyMatch(message, 'You entered: G', false)

WebUI.closeBrowser()