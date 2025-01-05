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

WebUI.openBrowser(GlobalVariable.URL_ORANGE)

// step 1: Get username text from Login form to enter into Username textbox
// Get username and password
String getUserName = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_UserName'), FailureHandling.CONTINUE_ON_FAILURE)
String getPassword = WebUI.getText(findTestObject('Object Repository/Login_Page/lbl_Password'), FailureHandling.CONTINUE_ON_FAILURE)
String userName = getUserName.split(":")[1].trim()
String password = getPassword.split(":")[1].trim()

// Check the inputted value is equal to the username text
WebUI.verifyEqual(userName,'Admin' , FailureHandling.CONTINUE_ON_FAILURE)
// Check the inputted value is equal to the pw text
WebUI.verifyEqual(password, 'admin123', FailureHandling.CONTINUE_ON_FAILURE)

// step 2: Get password text from Login form to enter into Password textbox
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_UserName') , userName, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'), password, FailureHandling.CONTINUE_ON_FAILURE)

// step 3: Click Login button
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'), FailureHandling.CONTINUE_ON_FAILURE)

// Wait for the Dashboard page to load'
WebUI.waitForPageLoad(10)
//Verify the Dashboard page title
WebUI.verifyElementText(findTestObject('Object Repository/Login_Page/h6_PageTitle'), 'Dashboard', FailureHandling.CONTINUE_ON_FAILURE)

// step 4: Select Logout in the User name control
WebUI.click(findTestObject('Object Repository/Login_Page/ddl_UserControl') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click( findTestObject('Object Repository/Login_Page/ddl_Logout'), FailureHandling.CONTINUE_ON_FAILURE)
// Check the user control is disappeared and the Login form is displayed
WebUI.verifyElementText(findTestObject('Object Repository/Login_Page/h5_LoginPageTitle'), 'Login', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementNotPresent( findTestObject('Object Repository/Login_Page/ddl_UserControl'), 0, FailureHandling.STOP_ON_FAILURE)

// Close Browser
WebUI.closeBrowser()