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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

// Click 'Horizontal Slider' link
WebUI.click(findTestObject('Object Repository/Verify_Slider/lnk_HorizontalSlider'))

// Check header title
WebUI.verifyElementText(findTestObject('Object Repository/Verify_Slider/lbl_HeaderTitle'), 'Horizontal Slider')

// Set Slider to 1
for (int i = 0; i < 2; i++) { 
    WebUI.sendKeys(findTestObject('Object Repository/Verify_Slider/Slider_Input'), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.verifyElementText(findTestObject('Object Repository/Verify_Slider/Slider_Value'), '1')

//Set Slider to 2.5
for (int i = 0; i < 3; i++) { 
    WebUI.sendKeys(findTestObject('Object Repository/Verify_Slider/Slider_Input'), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.verifyElementText(findTestObject('Object Repository/Verify_Slider/Slider_Value'), '2.5')

// Set Slider to 4.5
for (int i = 0; i < 4; i++) { 
    WebUI.sendKeys(findTestObject('Object Repository/Verify_Slider/Slider_Input'), Keys.chord(Keys.ARROW_RIGHT))
}
WebUI.verifyElementText(findTestObject('Object Repository/Verify_Slider/Slider_Value'), '4.5')


WebUI.closeBrowser()


