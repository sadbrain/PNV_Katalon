import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

try {
    'Step 1: Open the browser and navigate to the URL'
    WebUI.openBrowser('')
    WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
    
    'Step 2: Select "WYSIWYG Editor" link'
    WebUI.click(findTestObject('Object Repository/Page_VerifyFrames/lnk_WYSIWYGEditor'))
    
    'Verify that the page contains the iFrame with TinyMCE WYSIWYG Editor title'
    String pageTitle = WebUI.getText(findTestObject('Object Repository/Page_VerifyFrames/hdr_VerifyFrames'))
    WebUI.verifyMatch(pageTitle, '.*WYSIWYG Editor.*', false)
    
    'Step 3: Switch to the iFrame containing the TinyMCE editor'
    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_VerifyFrames/iframe_TinyMCEEditor'), 10)
    WebUI.switchToFrame(findTestObject('Object Repository/Page_VerifyFrames/iframe_TinyMCEEditor'), 10)
    
    'Step 4: Verify the default content inside the editor'
    String actualDefaultContent = WebUI.getText(findTestObject('Object Repository/Page_VerifyFrames/txt_Content'))
    String expectedDefaultContent = 'Your content goes here.'
    WebUI.verifyEqual(actualDefaultContent.trim(), expectedDefaultContent)
    
    'Step 5: Set new content "Hello, how are you?"'
    WebUI.setText(findTestObject('Object Repository/Page_VerifyFrames/txt_Content'), 'Hello, how are you?')
    
    'Step 6: Verify the new content inside the editor'
    String newContent = WebUI.getText(findTestObject('Object Repository/Page_VerifyFrames/txt_Content'))
    WebUI.verifyEqual(newContent.trim(), 'Hello, how are you?')
    
    'Step 7: Switch back to the main page and close the browser'
    WebUI.switchToDefaultContent()
    WebUI.closeBrowser()
} catch (Exception e) {
    WebUI.comment("An error occurred: " + e.getMessage())
    WebUI.takeScreenshot() // Take a screenshot in case of errors
    WebUI.closeBrowser()
}
