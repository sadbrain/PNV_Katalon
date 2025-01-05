import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

try {
    // Step 1: Call the LoginTest to reuse the login functionality
    WebUI.callTestCase(findTestCase('Test Cases/TC014 - Verify Login Function'), [:], FailureHandling.STOP_ON_FAILURE)

    // Step 2: Collapse the menu
    WebUI.click(findTestObject('Object Repository/TC015 - Verify main menu/btn_Toggle'))
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC015 - Verify main menu/btn_Toggle'), 5)

    // Step 3: Expand the menu
    WebUI.click(findTestObject('Object Repository/TC015 - Verify main menu/btn_UnToggle'))
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC015 - Verify main menu/btn_Toggle'), 5)

    // Step 4: Search for "My Info"
    WebUI.setText(findTestObject('Object Repository/TC015 - Verify main menu/SearchText'), 'My Info')
    WebUI.verifyElementVisible(findTestObject('Object Repository/TC015 - Verify main menu/MyInf'))
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC015 - Verify main menu/ToggleS'), 5)

    // Step 5: Search for "D"
    WebUI.setText( findTestObject('Object Repository/TC015 - Verify main menu/SearchText'),'D')
    WebUI.verifyElementVisible(findTestObject('Object Repository/TC015 - Verify main menu/MyInf'))
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC015 - Verify main menu/ToggleS'), 5)

    // Step 6: Click the "Dashboard" menu
    WebUI.click(findTestObject('Object Repository/TC015 - Verify main menu/DashBoard'))
    WebUI.waitForPageLoad(10)
    WebUI.verifyTitleContains('Dashboard')
    WebUI.verifyElementVisible(findTestObject('Object Repository/Dashboard/userControl'))

} catch (Exception e) {
    WebUI.comment("Test case failed: " + e.message)
} finally {
    // Close browser
    WebUI.closeBrowser()
}
