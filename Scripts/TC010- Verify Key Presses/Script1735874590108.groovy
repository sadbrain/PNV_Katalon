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

import org.openqa.selenium.Keys

' Step 1: Open browser and navigate to URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/key_presses')

' Step 2: Verify the header is Key Presses'
WebUI.verifyTextPresent('Key Presses', false)

' Step 3: Press Tab key and verify message'

WebUI.sendKeys( findTestObject('Object Repository/010- Verify Key Presses/txt_KeyPresses'), Keys.chord(Keys.CONTROL, '\t'))
WebUI.verifyElementText( findTestObject('Object Repository/010- Verify Key Presses/txt_PressedResult'), 'You entered: TAB', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys( findTestObject('Object Repository/010- Verify Key Presses/txt_KeyPresses'), Keys.chord(Keys.CONTROL, '\n'))
WebUI.verifyElementText( findTestObject('Object Repository/010- Verify Key Presses/txt_PressedResult'), 'You entered: ENTER', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys( findTestObject('Object Repository/010- Verify Key Presses/txt_KeyPresses'), Keys.chord(Keys.CONTROL, 'G'))
WebUI.verifyElementText( findTestObject('Object Repository/010- Verify Key Presses/txt_PressedResult'), 'You entered: G', FailureHandling.CONTINUE_ON_FAILURE)


WebUI.closeBrowser()