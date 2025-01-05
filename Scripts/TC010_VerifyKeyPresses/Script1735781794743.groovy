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
import com.kms.katalon.core.webui.driver.DriverFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Verify the presence of Key Presses link and click on it'
WebUI.click(findTestObject('Object Repository/KeyPresses_Page/lnk_KeyPresses'))

'Verify that the Key Presses header title is displayed'
WebUI.verifyTextPresent('Key Presses', false)

'Press TAB key and verify'
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_inputField'), Keys.chord(Keys.TAB))
WebUI.verifyElementText(findTestObject('Object Repository/KeyPresses_Page/rsl_resulMessage'), 'You entered: TAB')

'Press ENTER key and verify'
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_inputField'), Keys.chord(Keys.ENTER))
WebUI.verifyElementText(findTestObject('Object Repository/KeyPresses_Page/rsl_resulMessage'), 'You entered: ENTER')

'Press G key and verify'
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_inputField'), Keys.chord("G"))
WebUI.verifyElementText(findTestObject('Object Repository/KeyPresses_Page/rsl_resulMessage'), 'You entered: G')

'Close browser'
WebUI.closeBrowser()
