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
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/ColorandFontPage/lnk_ChallengingDOM'))
WebUI.verifyElementText(findTestObject('Object Repository/ColorandFontPage/txt_HeaderTitle'), 'Challenging DOM')

String fontSize = WebUI.getCSSValue(findTestObject('Object Repository/ColorandFontPage/btn_Button1'), 'font-size')
WebUI.verifyMatch(fontSize, '16px', false)

String backgroundColor = WebUI.getCSSValue(findTestObject('Object Repository/ColorandFontPage/btn_Button2'), 'background-color')
WebUI.verifyMatch(backgroundColor, 'rgb(198, 15, 19)', false)

String borderColor = WebUI.getCSSValue(findTestObject('Object Repository/ColorandFontPage/btn_Button3'), 'border-color')
WebUI.verifyMatch(borderColor, 'rgb(69, 122, 26)', false)

WebUI.closeBrowser()
