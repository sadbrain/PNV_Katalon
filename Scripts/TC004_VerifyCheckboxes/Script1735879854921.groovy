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
// step 1 : Go to https://the-internet.herokuapp.com/
WebUI.navigateToUrl(GlobalVariable.MENU_URL)

// Select ' Checkboxes' link
WebUI.click(findTestObject('Object Repository/Checkboxes_Page/lnk_Checkboxes'))

// navigate to link
WebUI.navigateToUrl('https://the-internet.herokuapp.com/checkboxes')
// verify Checkboxes header title is displayed
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/Checkboxes_Page/lbl_CheckboxsesTitle') ), "Checkboxes")

// step 2 :  Check 'checkbox1' and Uncheck 'checkbox 2'
WebUI.click(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'))

WebUI.click(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2'))

// verify checkbox1 is checked
WebUI.verifyElementChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox1'), 5 )

// verify uncheck 2 is un-checked
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Checkboxes_Page/chk_Checkbox2') , 5)

WebUI.closeBrowser()