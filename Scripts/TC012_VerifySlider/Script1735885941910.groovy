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

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'Step 1: '
'Navigate to Horizontal Slider page'
WebUI.click(findTestObject('Object Repository/Heroku_Page/lnk_HorizontalSlider'))
'Verify Horizontal Slider header title is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Horizontal_Slider_Page/h_HorizontalSliderTitle'), 'Horizontal Slider')

'Step 2: '
'Set Slider to 1'
for (int i = 0; i < 2; i++) {
	WebUI.sendKeys(findTestObject('Object Repository/Horizontal_Slider_Page/txt_HorizontalSlider'), Keys.chord(Keys.ARROW_RIGHT))
}
'verify Slider value is 1'
WebUI.verifyElementText(findTestObject('Object Repository/Horizontal_Slider_Page/sp_HorizontalSliderValue'), '1')

'Step 3: '
'Set Slider to 2.5'
for (int i = 0; i < 3; i++) {
	WebUI.sendKeys(findTestObject('Object Repository/Horizontal_Slider_Page/txt_HorizontalSlider'), Keys.chord(Keys.ARROW_RIGHT))
}
'verify Slider value is 2.5'
WebUI.verifyElementText(findTestObject('Object Repository/Horizontal_Slider_Page/sp_HorizontalSliderValue'), '2.5')

'Step 4: '
'Set Slider to 4.5'
for (int i = 0; i < 4; i++) {
	WebUI.sendKeys(findTestObject('Object Repository/Horizontal_Slider_Page/txt_HorizontalSlider'), Keys.chord(Keys.ARROW_RIGHT))
}
'verify Slider value is 4.5'
WebUI.verifyElementText(findTestObject('Object Repository/Horizontal_Slider_Page/sp_HorizontalSliderValue'), '4.5')

'Clean-up steps:'
WebUI.closeBrowser()