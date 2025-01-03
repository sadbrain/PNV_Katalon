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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

// Click 'Key Presses'
WebUI.click(findTestObject('Object Repository/Verify_KeyPresses/lnk_KeyPress'))

// Verify header title
String pageTitle = WebUI.getText(findTestObject('Object Repository/Verify_KeyPresses/lbl_HeaderKeyPress'))
assert pageTitle == 'Key Presses' : "Page title is incorrect" 

// Presses TAB
WebUI.sendKeys(findTestObject('Object Repository/Verify_KeyPresses/txt_KeyPressTarget'), Keys.chord(Keys.TAB))
WebUI.verifyTextPresent('You entered: TAB', false)

// Presses ENTER
WebUI.sendKeys(findTestObject('Object Repository/Verify_KeyPresses/txt_KeyPressTarget'), Keys.chord(Keys.ENTER))


// Presses G
WebUI.sendKeys(findTestObject('Object Repository/Verify_KeyPresses/txt_KeyPressTarget'), 'G')
WebUI.verifyTextPresent('You entered: G', false)

WebUI.closeBrowser()



