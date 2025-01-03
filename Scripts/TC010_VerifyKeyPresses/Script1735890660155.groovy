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

// Select 'Key Presses' link
WebUI.click(findTestObject('Object Repository/KeyPresses_Page/lnk_KeyPress'))

String expectedResult = "You entered: "
TestObject textObject = findTestObject('Object Repository/KeyPresses_Page/lbl_TextResult')

// Step 2 :Presses 'TAB' key
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_KeyPresses') , '\t')
WebUI.verifyEqual(WebUI.getText(textObject ) , expectedResult + "TAB")

// Prevent load Inject JavaScript to prevent the default action of the Enter key
String script = """
document.getElementById('target').addEventListener('keypress', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault(); 
    }
});
"""

WebUI.executeJavaScript(script, null)

// Step 3 : Presses 'ENTER' key
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_KeyPresses'), '\n')
WebUI.verifyEqual(WebUI.getText(textObject), expectedResult + "ENTER")

// Step 4 : Presses 'G' key
WebUI.setText( findTestObject('Object Repository/KeyPresses_Page/txt_KeyPresses'), "G")
WebUI.verifyEqual( WebUI.getText(textObject), expectedResult + "G")

WebUI.closeBrowser()