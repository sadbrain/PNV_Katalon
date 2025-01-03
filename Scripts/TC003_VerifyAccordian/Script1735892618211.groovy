import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('http://webdriveruniversity.com/Accordion/index.html')

WebUI.waitForElementNotVisible(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'), 10)
WebUI.verifyTextNotPresent("LOADING.. PLEASE WAIT..", false)
WebUI.verifyTextPresent("LOADING COMPLETE.", false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'), 5)
WebUI.click(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Accordion_Page/btn_HiddenText'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Accordion_Page/btn_HiddenText'), 'This text has appeared after 5 seconds!')
