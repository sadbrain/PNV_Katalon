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

' Step 1: Open browser and navigate to URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

'Step 2: Get UserName from Login form and enter to Username field'
String rawUserName = WebUI.getText(findTestObject('Object Repository/014 - Verify Login Function/txt_TestDataDefaultUserName'))
String rawPassword = WebUI.getText(findTestObject('Object Repository/014 - Verify Login Function/txt_TestDataDefaultPassword'))

String UserName = rawUserName.split(':')[1].trim()
String Password = rawPassword.split(':')[1].trim()

WebUI.setText(findTestObject('Object Repository/014 - Verify Login Function/txt_UserName'), UserName)
WebUI.setText(findTestObject('Object Repository/014 - Verify Login Function/txt_Password'), Password)

WebUI.click(findTestObject('Object Repository/014 - Verify Login Function/btn_Login'))

'Step 4: Choose Log out in user name control'
WebUI.click( findTestObject('Object Repository/014 - Verify Login Function/ddl_UserControl'))
WebUI.click(findTestObject('Object Repository/014 - Verify Login Function/option_LogOut') )

WebUI.closeBrowser()
