import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Step 1: Go to the URL and select 'Challenging DOM' link
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/challenging_dom')

String headerTitle = WebUI.getText(findTestObject('Object Repository/Challenging_Dom_Page/h_ChallengingDomTitle'))
WebUI.verifyEqual(headerTitle, 'Challenging DOM')

String button1FontSize = WebUI.getCSSValue(findTestObject('Object Repository/Challenging_Dom_Page/btn_1'), 'font-size')
WebUI.verifyEqual(button1FontSize, '16px')

String button2BackgroundColor = WebUI.getCSSValue(findTestObject('Object Repository/Challenging_Dom_Page/btn_2'), 'background-color')
WebUI.verifyEqual(button2BackgroundColor, 'rgba(198, 15, 19, 1)') 

// Step 4: Verify the border color of Button 3
String button3BorderColor = WebUI.getCSSValue(findTestObject('Object Repository/Challenging_Dom_Page/btn_3'), 'border-color')
WebUI.verifyEqual(button3BorderColor, 'rgb(69, 122, 26)') 
