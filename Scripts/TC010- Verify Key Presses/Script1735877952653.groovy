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

"Step 1"
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/key_presses')

"Verify Key Presses header title is displayed"
WebUI.verifyTextPresent('Key Presses', false, FailureHandling.CONTINUE_ON_FAILURE)

"Step 2"
"Press Tab key and verify message"
WebUI.sendKeys(findTestObject('Object Repository/TC010- Verify Key Presses/txt_KeyPresses'), Keys.chord(Keys.CONTROL, '\t'))
WebUI.verifyElementText(findTestObject('Object Repository/TC010- Verify Key Presses/txt_result'), 'You entered: TAB', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/TC010- Verify Key Presses/txt_KeyPresses'), Keys.chord(Keys.CONTROL, '\n'))
WebUI.verifyElementText(findTestObject('Object Repository/TC010- Verify Key Presses/txt_result'), 'You entered: ENTER', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/TC010- Verify Key Presses/txt_KeyPresses'), Keys.chord(Keys.CONTROL, 'G'))
WebUI.verifyElementText(findTestObject('Object Repository/TC010- Verify Key Presses/txt_result'), 'You entered: G', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

