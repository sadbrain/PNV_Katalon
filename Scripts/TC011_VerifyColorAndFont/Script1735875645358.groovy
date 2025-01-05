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

'Open browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Verify the presence of Challenging DOM link and click on it'
WebUI.click(findTestObject('Object Repository/ColorAndFont_Page/lnk_ChallengingDOM'))

'Verify that the Horizontal Slider header title is displayed'
WebUI.verifyTextPresent('Challenging DOM', false)

'Verify font size of button 1'
String fontSizeButton1 = WebUI.getCSSValue(findTestObject('Object Repository/Buttons/button1'), 'font-size')
WebUI.verifyEqual(fontSizeButton1, '16px')

'Verify background color of button 2'
String backgroundColorButton2 = WebUI.getCSSValue(findTestObject('Object Repository/Buttons/button2'), 'background-color')
WebUI.verifyEqual(backgroundColorButton2, 'rgb(198, 15, 19)') 

'Verify border color of button 3'
String borderColorButton3 = WebUI.getCSSValue(findTestObject('Object Repository/Buttons/button3'), 'border-color')
WebUI.verifyEqual(borderColorButton3, 'rgb(69, 122, 26)')

'Close the browser'
WebUI.closeBrowser()