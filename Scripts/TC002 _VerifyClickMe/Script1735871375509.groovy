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

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.CLICKME)

WebUI.click(findTestObject('Object Repository/verify_ClickMe/btn_ClickMeWeb'))
WebUI.verifyTextPresent("Well done for successfully using the click() method!", false)
WebUI.click(findTestObject('Object Repository/verify_ClickMe/btn_CloseClickMeWeb'))
WebUI.click(findTestObject('Object Repository/verify_ClickMe/btn_ClickMeJavaScript'))
WebUI.verifyTextPresent("It’s that Easy!! Well I think it is.....\nWe can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).", false)
WebUI.click(findTestObject('Object Repository/verify_ClickMe/btn_CloseClickMeJs'))
WebUI.click(findTestObject('Object Repository/verify_ClickMe/btn_ClickMeAction'))
WebUI.verifyTextPresent("Well done! the Action Move & Click can become very useful!\nAdvanced user interactions (API) has been developed to enable you to perform more complex interactions such as:\nDrag & Drop\nHover & Click\nClick & Hold....", false)