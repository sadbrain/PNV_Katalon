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

'Step 1: '
'Open the browser and navigate to the login page'
WebUI.openBrowser(GlobalVariable.URL_ORANGE_DEMO)

'Step 2: '
'Get username text from the Login form'
String usernameText = WebUI.getText(findTestObject('Object Repository/Login_Page/p_Username'))

// Phân tích chuỗi để lấy giá trị username
String username = usernameText.split(":")[1].trim()
println("Extracted Username: " + username)

'Enter the extracted username into the Username textbox'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Username'), username)

'Verify the username is entered successfully'
String enteredUsername = WebUI.getAttribute(findTestObject('Object Repository/Login_Page/txt_Username'), 'value')
WebUI.verifyMatch(enteredUsername, username, false)

'Step 3: '
'Get password text from the Login form'
String passwordText = WebUI.getText(findTestObject('Object Repository/Login_Page/p_Password'))

// Phân tích chuỗi để lấy giá trị password
String password = passwordText.split(":")[1].trim()
println("Extracted Password: " + password)

'Enter the extracted password into the password textbox'
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'), password)

'Verify the password is entered successfully'
String enteredPassword = WebUI.getAttribute(findTestObject('Object Repository/Login_Page/txt_Password'), 'value')
WebUI.verifyMatch(enteredPassword, password, false)

'Step 4: '
'Click on the "Login" button in the login form'
WebUI.click(findTestObject('Object Repository/Login_Page/btn_Login'))

'Wait for the Dashboard page to load'
WebUI.waitForPageLoad(10)

'Verify the Dashboard page title'
String expectedTitle = "Dashboard"
String dashboardText = WebUI.getText(findTestObject('Object Repository/Login_Page/p_DashboardTitle'))
WebUI.verifyMatch(dashboardText, expectedTitle, false)

'Verify the control is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Step 5: '
'Select Logout in the User name control'
WebUI.click(findTestObject('Object Repository/Login_Page/p_UserControlName'))
WebUI.click(findTestObject('Object Repository/Login_Page/ddl_Logout'))

'Verify that the Login form is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_Page/p_LoginTitle'), 10)

'Verify that the user control is disappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Login_Page/ddl_UserControl'), 10)

'Clean-up steps:'
WebUI.closeBrowser()