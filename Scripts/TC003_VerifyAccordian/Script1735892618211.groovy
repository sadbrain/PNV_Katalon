import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open browser and navigate to the page
WebUI.openBrowser('')
WebUI.navigateToUrl('http://webdriveruniversity.com/Accordion/index.html')

// Wait until "LOADING.. PLEASE WAIT.." text is changed to "LOADING COMPLETE."
WebUI.waitForElementNotVisible(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'), 10)
WebUI.verifyTextNotPresent("LOADING.. PLEASE WAIT..", false)
WebUI.verifyTextPresent("LOADING COMPLETE.", false)

// Click the "Keep Clicking! - Text will Appear After 5 Seconds!" accordion item
WebUI.waitForElementVisible(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'), 5)
WebUI.click(findTestObject('Object Repository/Accordion_Page/btn_KeepClicking'))

// Wait for the text to appear within the accordion item
WebUI.waitForElementVisible(findTestObject('Object Repository/Accordion_Page/btn_HiddenText'), 10)

// Verify the presence of the text after clicking the accordion item
WebUI.verifyElementText(findTestObject('Object Repository/Accordion_Page/btn_HiddenText'), 'This text has appeared after 5 seconds!')
