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
WebUI.navigateToUrl(GlobalVariable.HRM)



// Lấy nội dung Username và Password từ màn hình
String usernameText = WebUI.getText(findTestObject('Object Repository/Verify_LoginFunction/lbl_UserNameText')).split(': ')[1]
String passwordText = WebUI.getText(findTestObject('Object Repository/Verify_LoginFunction/lbl_PasswordText')).split(': ')[1]

// Điền Username vào ô input
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), usernameText)

// Điền Password vào ô input
WebUI.setText(findTestObject('Object Repository/Verify_LoginFunction/txt_Password'), passwordText)


// Step 4: Click on the Login button
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/btn_Login'))

// Step 5: Verify The Dashboard page is loaded successfully
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/hdr_Dashboard'), 10)

// Step 6: Logout 
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/btn_Profile'))
WebUI.click(findTestObject('Object Repository/Verify_LoginFunction/lnk_Logout'))

// Step 7: Verify Logout successfully
WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_LoginFunction/txt_Username'), 10)

WebUI.closeBrowser()
