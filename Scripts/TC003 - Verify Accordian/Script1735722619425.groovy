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


WebUI.openBrowser('')
WebUI.navigateToUrl('http://webdriveruniversity.com/Accordion/index.html')

// Đợi cho đến khi đối tượng xuất hiện trên trang và có văn bản LOADING COMPLETE
WebUI.waitForElementVisible(findTestObject('Object Repository/TC003 - Verify Accordian/txa_LoadingText'), 10, FailureHandling.OPTIONAL)
WebUI.verifyTextPresent('LOADING COMPLETE.', false, FailureHandling.OPTIONAL)

// Nhấp vào nút "Keep Clicking"
WebUI.click(findTestObject('Object Repository/TC003 - Verify Accordian/btn_KeepClicking'), FailureHandling.OPTIONAL)

// Đợi cho đến khi văn bản "This text has appeared after 5 seconds!" xuất hiện
WebUI.waitForElementVisible(findTestObject('Object Repository/TC003 - Verify Accordian/txa_After5SecondsText'), 10, FailureHandling.OPTIONAL)
WebUI.verifyTextPresent('This text has appeared after 5 seconds!', false, FailureHandling.OPTIONAL)
