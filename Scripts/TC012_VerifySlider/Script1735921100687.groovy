import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/horizontal_slider')

String headerTitle = WebUI.getText(findTestObject('Object Repository/Horizontal_Slider_Page/h_HorizontalSliderTitle'))
WebUI.verifyEqual(headerTitle, 'Horizontal Slider')

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
