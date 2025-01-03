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

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

'Step 1: '
'Navigate to press key page'
WebUI.click(findTestObject('Object Repository/Key_Presses_Page/lnk_KeyPress'))
'Verify Key Presses title is diplayed'
WebUI.verifyElementText(findTestObject('Object Repository/Key_Presses_Page/h_KeyPressesTitle'), 'Key Presses')

'Step 2: '
'Press TAB key'
WebUI.sendKeys(findTestObject('Object Repository/Key_Presses_Page/frm_KeyPressesForm'), Keys.chord(Keys.TAB))
'Verify the Messagse "You entered: TAB" is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Key_Presses_Page/p_KeyPressResult'), 'You entered: TAB')

'Step 3: '
'Press ENTER key'
WebUI.sendKeys(findTestObject('Object Repository/Key_Presses_Page/frm_KeyPressesForm'), Keys.chord(Keys.ENTER))
'Verify the Messagse "You entered: ENTER" is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Key_Presses_Page/p_KeyPressResult'), 'You entered: ENTER')

'Step 4: '
'Press G key'
WebUI.sendKeys(findTestObject('Object Repository/Key_Presses_Page/frm_KeyPressesForm'), Keys.chord("G"))
'Verify the Messagse "You entered: G" is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Key_Presses_Page/p_KeyPressResult'), 'You entered: G')

'Clean-up steps:'
WebUI.closeBrowser()