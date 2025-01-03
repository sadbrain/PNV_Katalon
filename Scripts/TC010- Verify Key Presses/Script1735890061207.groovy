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
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys

// Step 1: Go to the URL and navigate to 'Key Presses'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/TC010- Verify Key Presses/lnk_KeyPresses'))

// Verify "Key Presses" header title is displayed
String header = WebUI.getText(findTestObject('Object Repository/TC010- Verify Key Presses/h3_Header'))
WebUI.verifyEqual(header, 'Key Presses', FailureHandling.CONTINUE_ON_FAILURE)

// Step 2: Press 'TAB' key
WebUI.sendKeys(findTestObject('Object Repository/TC010- Verify Key Presses/txa_KeyPressField'), Keys.chord(Keys.TAB), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyTextPresent('You entered: TAB', false,  FailureHandling.CONTINUE_ON_FAILURE)

// Step 3: Press 'ENTER' key
WebUI.sendKeys(findTestObject('Object Repository/TC010- Verify Key Presses/txa_KeyPressField'), Keys.chord(Keys.ENTER),  FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyTextPresent('You entered: ENTER', false, FailureHandling.CONTINUE_ON_FAILURE)

// Step 4: Press 'G' key
WebUI.sendKeys(findTestObject('Object Repository/TC010- Verify Key Presses/txa_KeyPressField'), 'G')
WebUI.verifyTextPresent('You entered: G', false)

// Close the browser
WebUI.closeBrowser()

