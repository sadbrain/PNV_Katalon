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

'Step 1'
'Open and navigate to URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://webdriveruniversity.com/Accordion/index.html')

'Step 2'
'Wait until "LOADING.. PLEASE WAIT.." text is changed to "LOADING COMPLETE." text'

TestObject loadingTextObject = findTestObject('Object Repository/003 - Verify Accordian/div_TextChange')                 
int timeout = 20
boolean isTextChanged = false

for (int i = 0; i < timeout; i++) {
    String currentText = WebUI.getText(loadingTextObject)
    WebUI.comment('Current text: ' + currentText) 
  
    if (currentText == 'LOADING COMPLETE.') {
        isTextChanged = true
        break
    }

 
    WebUI.delay(1)
}

if (isTextChanged) {
    WebUI.comment('The text changed to "LOADING COMPLETE."')
} else {
    WebUI.comment('Timeout waiting for text change.')
}

'Step 3'
'Click to "Keep Clicking'
WebUI.click(findTestObject('Object Repository/003 - Verify Accordian/btn_KeepClick') )
'Verify the text "This text has appeared after 5 seconds!" displayed'
WebUI.verifyElementText( findTestObject('Object Repository/003 - Verify Accordian/div_TextAppearAfterClickKeepbtn'), 'This text has appeared after 5 seconds!')

WebUI.closeBrowser()
