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

// step 1: Go to http://webdriveruniversity.com/Click-Buttons/index.html
WebUI.openBrowser(GlobalVariable.CLICKBUTTON_URL)


String webElementString = "Well done for successfully using the click() method!"
String javascriptHeaderString = "It’s that Easy!! Well I think it is....."
String javaScriptBodyString = "We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc)."
String actionMoveString = "Well done! the Action Move & Click can become very useful!\nAdvanced user interactions (API) has been developed to enable you to perform more complex interactions such as:"
String listAction = "\nDrag & Drop\nHover & Click\nClick & Hold...."

// Step 2: Click to "Click Me" button in WebElement Click section
WebUI.click(findTestObject('Object Repository/ClickMeButton_Page/btn_Open_WebElementModal'))

// Verify text dislay :
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/ClickMeButton_Page/lbl_ModalWebELement')), webElementString)

// step 3 : Close the modal and Click to "Click Me" button in JavaScript Click section
WebUI.click(findTestObject('Object Repository/ClickMeButton_Page/btn_Close_WebElement'))
WebUI.click(findTestObject('Object Repository/ClickMeButton_Page/btn_Open_JavaScriptModal'))

// Verify text dislay :
WebUI.verifyTextPresent(javascriptHeaderString, false)
WebUI.verifyTextPresent(javaScriptBodyString, false)

// Step 4 : Close the dialog and Click to "Click Me" button in Action Move & Click
WebUI.click(findTestObject('Object Repository/ClickMeButton_Page/btn_Close_JavaScript'))
WebUI.click(findTestObject('Object Repository/ClickMeButton_Page/btn_Open_ActionMoveModal'))

// Verify text display
WebUI.verifyTextPresent(actionMoveString, false)
WebUI.verifyTextPresent(listAction, false)

WebUI.click(findTestObject('Object Repository/ClickMeButton_Page/btn_Close_ActionMove'))

WebUI.closeBrowser()