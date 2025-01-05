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
WebUI.openBrowser(GlobalVariable.URL_CONTACT)

'Enter "FName" to the first name text box'
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txt_FirstName'), 'FName')

'Enter "LName" to the last name text box'
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txt_LastName'), 'LName')

'Enter "test@gmail.com" to the email text box'
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txt_Email'), 'test@gmail.com')

'Enter  "This is a comment" to the comment text box'
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txa_Comments'), 'This is a comment')

'Click Submit button'
WebUI.click(findTestObject('Object Repository/ContactUs_Page/btn_Submit'))

'Verify that the message "Thank You for your Message!" text is displayed'
WebUI.verifyTextPresent('Thank You for your Message!', false)

'Close browser'
WebUI.closeBrowser()

