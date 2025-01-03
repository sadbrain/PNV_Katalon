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
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

// Test Case: TC011 - Verify Color and Font

// Step 1: Go to https://the-internet.herokuapp.com/ and Select 'Challenging DOM' link
WebUI.openBrowser('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/TC011 - Verify Color and Font/lnk_ChallengingDOM'))  

// Step 2: Verify Challenging DOM header title is displayed
String header = WebUI.getText(findTestObject('Object Repository/TC011 - Verify Color and Font/h3_Header'))
WebUI.verifyEqual(header, 'Challenging DOM', FailureHandling.CONTINUE_ON_FAILURE)

// Step 3: Verify font size of button 1 is 16px
WebElement button1 = WebUI.findWebElement(findTestObject('Object Repository/TC011 - Verify Color and Font/btn_Button1')) 
String button1FontSize = button1.getCssValue('font-size')
WebUI.verifyEqual(button1FontSize, '16px', FailureHandling.CONTINUE_ON_FAILURE)

// Step 4: Verify background-color of button 2 is #c60f13
WebElement button2 = WebUI.findWebElement(findTestObject('Object Repository/TC011 - Verify Color and Font/btn_Button2'))
String button2BackgroundColor = button2.getCssValue('background-color')
WebUI.verifyEqual(button2BackgroundColor, 'rgb(198, 15, 19)', FailureHandling.CONTINUE_ON_FAILURE) 

// Step 5: Verify border-color of button 3 is #457a1a
WebElement button3 = WebUI.findWebElement(findTestObject('Object Repository/TC011 - Verify Color and Font/btn_Button3')) 
String button3BorderColor = button3.getCssValue('border-color')
WebUI.verifyEqual(button3BorderColor, 'rgb(69, 122, 26)') 

// Close the browser
WebUI.closeBrowser()

