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

// Step 1: Open the website
WebUI.openBrowser('')
WebUI.navigateToUrl('http://webdriveruniversity.com/Click-Buttons/index.html')

// Step 2: Click "Click Me" in WebElement Click section
WebUI.click(findTestObject('Object Repository/TC002 - Verify Click Me/btn_WebElementClick'))
WebUI.verifyTextPresent('Well done for successfully using the click() method!', false)
WebUI.click(findTestObject('Object Repository/TC002 - Verify Click Me/btn_Close_ClickMe'))

// Step 3: Click "Click Me" in JavaScript Click section
WebUI.click(findTestObject('Object Repository/TC002 - Verify Click Me/btn_JavaScriptClick'))
WebUI.verifyTextPresent('It’s that Easy!! Well I think it is.....', false)
WebUI.click(findTestObject('Object Repository/TC002 - Verify Click Me/btn_Close_JavaScriptClick'))

// Step 4: Click "Click Me" in Action Move & Click section
WebUI.click(findTestObject('Object Repository/TC002 - Verify Click Me/btn_ActionMoveClick'))
WebUI.verifyTextPresent('Well done! the Action Move & Click can become very useful!', false)
WebUI.click(findTestObject('Object Repository/TC002 - Verify Click Me/btn_Close_ActionMoveClick'))


