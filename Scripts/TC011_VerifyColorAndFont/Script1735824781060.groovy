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

def rgbaToHex(String rgba) {
    if (rgba.contains("rgba")) {
        def rgbValues = rgba.replace("rgba(", "").replace(")", "").split(",")
        String red = rgbValues[0].trim()
        String green = rgbValues[1].trim()
        String blue = rgbValues[2].trim()
        
        return String.format("#%02X%02X%02X", red.toInteger(), green.toInteger(), blue.toInteger())
    } else if (rgba.contains("rgb")) {
        def rgbValues = rgba.replace("rgb(", "").replace(")", "").split(",")
        String red = rgbValues[0].trim()
        String green = rgbValues[1].trim()
        String blue = rgbValues[2].trim()
        
        return String.format("#%02X%02X%02X", red.toInteger(), green.toInteger(), blue.toInteger())
    } else {
        throw new IllegalArgumentException("Invalid color format: " + rgba)
    }
}

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'Step 1: '
'Navigate to Challenging DOM page'
WebUI.click(findTestObject('Object Repository/Challenging_Dom_Page/lnk_Challenging_DOM'))

'Verify that "Challenging DOM" header title is displayed'
WebUI.verifyTextPresent("Challenging DOM", false)

'Step 2: '
'Verify the font size of Button 1 is 16px'
WebUI.verifyMatch(WebUI.getCSSValue(findTestObject('Object Repository/Challenging_Dom_Page/btn_1'), 'font-size'), '16px', false)

'Step 3: '
'Verify background-color of Button 2 is #c60f13'
String buttonColor = WebUI.getCSSValue(findTestObject('Object Repository/Challenging_Dom_Page/btn_2'), 'background-color')
String hexColor = rgbaToHex(buttonColor)  
WebUI.verifyMatch(hexColor, '#C60F13', false)

'Step 4: '
'Verify border-color of Button 3 is #457a1a'
String buttonBorderColor = WebUI.getCSSValue(findTestObject('Object Repository/Challenging_Dom_Page/btn_3'), 'border-color')
String hexBorderColor = rgbaToHex(buttonBorderColor)  
WebUI.verifyMatch(hexBorderColor, '#457A1A', false)

'Clean-up steps:'
WebUI.closeBrowser()