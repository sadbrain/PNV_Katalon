import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open browser and navigate to the main page
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/checkboxes')

// Verify that the Checkboxes header title is displayed
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes_Page/txt_CheckboxesHeader'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Checkboxes_Page/txt_CheckboxesHeader'), 'Checkboxes')

// Wait for the checkboxes to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 10)
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'), 10)

// Check 'checkbox1' and uncheck 'checkbox2'
WebUI.check(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'))
WebUI.uncheck(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'))

// Verify 'checkbox1' is checked and 'checkbox2' is unchecked
WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 0)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'), 0)

// Close the browser
WebUI.closeBrowser()
