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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.HEROKUAPP)

// Step 1: Click on the "Key Presses" link
WebUI.click(findTestObject('Object Repository/Verify_KeyPresses/lnk_KeyPresses'))

// Step 2: Verify the header is "Key Presses"
String headerText = WebUI.getText(findTestObject('Object Repository/Verify_KeyPresses/hdr_KeyPresses'))
WebUI.verifyEqual(headerText, "Key Presses")

// Prevent load Inject JavaScript to prevent the default action of the Enter key
String script = """
document.getElementById('target').addEventListener('keypress', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault(); 
    }
});
"""
WebUI.executeJavaScript(script, null)

// Step 3: Send the TAB key and verify the result
WebUI.sendKeys(findTestObject('Object Repository/Verify_KeyPresses/Input_FieldKeyPresses'), '\t')
WebUI.delay(1) // Delay to observe the result
String tabResult = WebUI.getText(findTestObject('Object Repository/Verify_KeyPresses/msg_KeyPressResult'))
WebUI.verifyEqual(tabResult, "You entered: TAB")

// Step 4: Send the ENTER key and verify the result
WebUI.sendKeys(findTestObject('Object Repository/Verify_KeyPresses/Input_FieldKeyPresses'), '\n')
WebUI.delay(1) // Delay to observe the result
String enterResult = WebUI.getText(findTestObject('Object Repository/Verify_KeyPresses/msg_KeyPressResult'))
WebUI.verifyEqual(enterResult, "You entered: ENTER")

// Step 5: Send the letter G and verify the result
WebUI.sendKeys(findTestObject('Object Repository/Verify_KeyPresses/Input_FieldKeyPresses'), 'G')
WebUI.delay(1) // Delay to observe the result
String gResult = WebUI.getText(findTestObject('Object Repository/Verify_KeyPresses/msg_KeyPressResult'))
WebUI.verifyEqual(gResult, "You entered: G")

WebUI.closeBrowser()
