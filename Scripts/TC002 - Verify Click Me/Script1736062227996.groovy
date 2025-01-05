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


String webElementContent = "Well done for successfully using the click() method!"
String javascriptHeader = "It’s that Easy!! Well I think it is....."
String javaScriptBody = "We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc)."
String actionMoveContent = "Well done! the Action Move & Click can become very useful!\nAdvanced user interactions (API) has been developed to enable you to perform more complex interactions such as:"
String listAction = "\nDrag & Drop\nHover & Click\nClick & Hold...."

// step 1: Open browser and Go to http://webdriveruniversity.com/Click-Buttons/index.html
WebUI.openBrowser('https://webdriveruniversity.com/Click-Buttons/index.html')

// step 2: Click to "Click Me" button in WebElement Click section
WebUI.click(findTestObject('Object Repository/ClickButton_Page/btn_WebElement') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify text dislay :
WebUI.verifyTextPresent(webElementContent , false, FailureHandling.CONTINUE_ON_FAILURE)

// step 3: Close the modal and Click to "Click Me" button in JavaScript Click section
WebUI.click(findTestObject('Object Repository/ClickButton_Page/btn_WebElementClose') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/ClickButton_Page/btn_JavaScript') , FailureHandling.CONTINUE_ON_FAILURE)


// Verify text dislay :
WebUI.verifyTextPresent(javascriptHeader, false)
WebUI.verifyTextPresent(javaScriptBody, false)
// Step 4 : Close the dialog and Click to "Click Me" button in Action Move & Click
WebUI.click(findTestObject('Object Repository/ClickButton_Page/btn_JavaScriptClose') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/ClickButton_Page/btn_ActionMove') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify text display
WebUI.verifyTextPresent(actionMoveContent, false)
WebUI.verifyTextPresent(listAction, false)

// Close Modal and Browser
WebUI.click( findTestObject('Object Repository/ClickButton_Page/btn_ActionMoveClose'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.closeBrowser()