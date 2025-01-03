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
// Function to convert Hex color to RGB or RGBA based on the requirement
def hexToColor(String hex, boolean includeAlpha = false) {
    // Remove '#' if present
    hex = hex.replace('#', '')
    
    // Parse the red, green, and blue values from the hex code
    int r = Integer.parseInt(hex.substring(0, 2), 16)
    int g = Integer.parseInt(hex.substring(2, 4), 16)
    int b = Integer.parseInt(hex.substring(4, 6), 16)
    
    // If alpha is needed, return rgba (with alpha = 1), otherwise return rgb
    if (includeAlpha) {
        return "rgba($r, $g, $b, 1)"
    } else {
        return "rgb($r, $g, $b)"
    }
}

// Step 1: Open browser and navigate to URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/challenging_dom')

// Step 2: Verify the header is Challenging DOM
WebUI.verifyTextPresent('Challenging DOM', false)

// Step 3: Verify font size button 1 is 16px
String fontSize = WebUI.getCSSValue(findTestObject('Object Repository/TC011 - Verify Color and Font/btn_Bar_Button'), 'font-size')
WebUI.verifyMatch(fontSize, '16px', false, FailureHandling.CONTINUE_ON_FAILURE)

// Step 4: Verify background button is #c60f13 (hex) converted to rgba
def expectedRgba = hexToColor('#c60f13', true)  // Convert Hex to RGBA
def actualColor = WebUI.getCSSValue(findTestObject('Object Repository/TC011 - Verify Color and Font/btn_foo_button'), 'background-color')
WebUI.verifyMatch(actualColor, expectedRgba, false)

// Step 5: Verify border-color is #457a1a (hex) converted to rgb
def expectedRgb = hexToColor('#457a1a', false)  // Convert Hex to RGB
def actualBorder = WebUI.getCSSValue(findTestObject('Object Repository/TC011 - Verify Color and Font/btn_qux_button'), 'border-color')
WebUI.verifyMatch(actualBorder, expectedRgb, false)

WebUI.closeBrowser()