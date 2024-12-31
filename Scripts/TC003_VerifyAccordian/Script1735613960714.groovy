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
WebUI.navigateToUrl('http://webdriveruniversity.com/Accordion/index.html')


TestObject loadingStatus = findTestObject('Object Repository/Page_ Accordian/txt_LoadingStatus')
int timeout = 10
int elapsedTime = 0
boolean isTextMatched = false

while (elapsedTime < timeout) {
    String actualText = WebUI.getText(loadingStatus)
    if (actualText == 'LOADING COMPLETE.') {
        isTextMatched = true
        break
    }
    WebUI.delay(1)
    elapsedTime++
}

if (!isTextMatched) {
    WebUI.comment('Failed: Text did not update to "LOADING COMPLETE." within the timeout period.')
    WebUI.closeBrowser()
    assert false
}


TestObject accordionItem = findTestObject('Object Repository/Page_ Accordian/btn_KeepClicking')
WebUI.click(accordionItem)

TestObject textAfter5Seconds = findTestObject('Object Repository/Page_ Accordian/Txt_AfterClick')
WebUI.waitForElementVisible(textAfter5Seconds, 10)
String actualMessage = WebUI.getText(textAfter5Seconds)
WebUI.verifyEqual(actualMessage, 'This text has appeared after 5 seconds!')

WebUI.closeBrowser()