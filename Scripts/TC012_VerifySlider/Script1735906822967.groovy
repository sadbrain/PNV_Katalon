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

'Step 1: '
'Go to https://the-internet.herokuapp.com/ and Select Horizontal Slider link'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)
WebUI.click(findTestObject('Object Repository/Horizontal_Slider_Page/lnk_HorizontalSlider'), FailureHandling.CONTINUE_ON_FAILURE)

'Step 2: '
'Check header title'
WebUI.verifyElementText(findTestObject('Object Repository/Horizontal_Slider_Page/h_HorizontalSliderTitle'), 'Horizontal Slider')

'The function moves the slider to the desired value'
void moveSliderToValue(TestObject slider, TestObject sliderValue, double targetValue) {
    double currentValue = Double.parseDouble(WebUI.getText(sliderValue))
    while (currentValue < targetValue) {
        WebUI.sendKeys(slider, Keys.chord(Keys.ARROW_RIGHT))
        currentValue = Double.parseDouble(WebUI.getText(sliderValue))
    }
    WebUI.verifyEqual(currentValue, targetValue, FailureHandling.CONTINUE_ON_FAILURE)
}

'Get slider input and slider value'
TestObject slider = findTestObject('Object Repository/Horizontal_Slider_Page/sld_Input')
TestObject sliderValue = findTestObject('Object Repository/Horizontal_Slider_Page/sld_Value')

'Step 3: '
'Set Slider to 1'
moveSliderToValue(slider, sliderValue, 1.0)

'Step 4: '
'Set Slider to 2.5'
moveSliderToValue(slider, sliderValue, 2.5)

'Step 5: '
'Set Slider to 4.5'
moveSliderToValue(slider, sliderValue, 4.5)

'Close browser'
WebUI.closeBrowser()
