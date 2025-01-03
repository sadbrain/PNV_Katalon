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
WebUI.click(findTestObject('Object Repository/ColorAndFont_Page/lnk_ChallengingDOM'))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/ColorAndFont_Page/lbl_ChanllengingDOM') ), "Challenging DOM")

// Step 2: Verify font size of button 1
String fontZise = WebUI.getCSSValue(findTestObject('Object Repository/ColorAndFont_Page/btn_Button1'), 'font-size')
WebUI.verifyEqual(fontZise, "16px")

// Step 3 : Verify background-color of button 2
String backgroundColor = WebUI.getCSSValue(findTestObject('Object Repository/ColorAndFont_Page/btn_Button2'), 'background-color')
WebUI.verifyEqual(convertColorToHex(backgroundColor), '#c60f13')

// Step 4 : Verify border-color of button 3
String borderColor = WebUI.getCSSValue(findTestObject('Object Repository/ColorAndFont_Page/btn_Button3'), 'border-color')
WebUI.verifyEqual( convertColorToHex(borderColor), '#457a1a')

// convert color 
String convertColorToHex(String colorValue) {
	if (colorValue.startsWith('rgba')) {
		String[] rgba = colorValue.replaceAll("[rgba()]", "").split(",")
		int r = Integer.parseInt(rgba[0].trim())
		int g = Integer.parseInt(rgba[1].trim())
		int b = Integer.parseInt(rgba[2].trim())
		return String.format("#%02x%02x%02x", r, g, b)
	} else if (colorValue.startsWith('rgb')) {
		String[] rgb = colorValue.replaceAll("[rgb()]", "").split(",")
		int r = Integer.parseInt(rgb[0].trim())
		int g = Integer.parseInt(rgb[1].trim())
		int b = Integer.parseInt(rgb[2].trim())
		return String.format("#%02x%02x%02x", r, g, b)
	} else {
		return colorValue
	}
}

WebUI.closeBrowser()