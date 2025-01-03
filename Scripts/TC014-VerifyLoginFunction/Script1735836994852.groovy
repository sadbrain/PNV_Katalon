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
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

String usernameText = WebUI.getText(findTestObject('Object Repository/LoginFunctionPage/lbl_Username'))

WebUI.setText(findTestObject('Object Repository/LoginFunctionPage/txt_UsernameInput'), GlobalVariable.USER_NAME)

String enteredUsername = WebUI.getAttribute(findTestObject('Object Repository/LoginFunctionPage/txt_UsernameInput'), 'value')
WebUI.verifyMatch(enteredUsername, GlobalVariable.USER_NAME, false)

String passwordText = WebUI.getText(findTestObject('Object Repository/LoginFunctionPage/lbl_Password'))

WebUI.setText(findTestObject('Object Repository/LoginFunctionPage/txt_PasswordInput'), GlobalVariable.PASSWORD)

String enteredPassword = WebUI.getAttribute(findTestObject('Object Repository/LoginFunctionPage/txt_PasswordInput'), 'value')
WebUI.verifyMatch(enteredPassword, GlobalVariable.PASSWORD, false)

WebUI.click(findTestObject('Object Repository/LoginFunctionPage/btn_Login'))

WebUI.waitForPageLoad(10)

String expectedTitle = "Dashboard"
String dashboardText = WebUI.getText(findTestObject('Object Repository/LoginFunctionPage/txt_DashboardTitle'))
WebUI.verifyMatch(dashboardText, expectedTitle, false)

WebUI.verifyElementPresent(findTestObject('Object Repository/LoginFunctionPage/lnk_UsernameControl'), 10)

WebUI.click(findTestObject('Object Repository/LoginFunctionPage/p_UserControlName'))
WebUI.click(findTestObject('Object Repository/LoginFunctionPage/lnk_Logout'))

WebUI.verifyElementPresent(findTestObject('Object Repository/LoginFunctionPage/p_LoginTitle'), 10)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/LoginFunctionPage/lnk_UsernameControl'), 10)

