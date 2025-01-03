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


// step 1: Go to https://the-internet.herokuapp.com/ and Select 'Challenging DOM' link
WebUI.openBrowser(GlobalVariable.URL_HERROKUAPP, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/ChallengingDom_Page/lnk_ChallengingDOM') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify 'Challenging DOM header title is displayed
WebUI.verifyElementText( findTestObject('Object Repository/ChallengingDom_Page/h3_HeaderTitle'), 'Challenging DOM', FailureHandling.CONTINUE_ON_FAILURE)

// step 2: Verify font size of button 1 :Font size is 16px
WebUI.verifyMatch(WebUI.getCSSValue(findTestObject('Object Repository/ChallengingDom_Page/btn_1'), 'font-size'), '16px', false)

// step 3: Verify background-color of button 2:Background-color is #c60f13 (hex) color
String buttonColor = WebUI.getCSSValue(findTestObject('Object Repository/ChallengingDom_Page/btn_2'), 'background-color')
String hexColor = rgbaToHex(buttonColor)
WebUI.verifyMatch(hexColor, '#C60F13', false)

// step 4: Verify border-color of button 3: Border-color is #457a1a (hex) color
String buttonBorderColor = WebUI.getCSSValue(findTestObject('Object Repository/ChallengingDom_Page/btn_3'), 'border-color')
String hexBorderColor = rgbaToHex(buttonBorderColor)
WebUI.verifyMatch(hexBorderColor, '#457A1A', false)

// close browser
WebUI.closeBrowser()
