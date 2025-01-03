import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/checkboxes')

WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes_Page/txt_CheckboxesHeader'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Checkboxes_Page/txt_CheckboxesHeader'), 'Checkboxes')

WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 10)
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'), 10)

WebUI.check(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'))
WebUI.uncheck(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'))

WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 0)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'), 0)
