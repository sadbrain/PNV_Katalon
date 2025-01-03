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

'Open the browser and navigate to the URL'
WebUI.openBrowser('')
WebUI.navigateToMaskedUrl(GlobalVariable.URL_CONTACT)
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_FirstName'), 'Xươm')
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_LastName'), 'Hồ')
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_Email'), 'xuomho@gmail.com')
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txa_Comment'), 'good')

'Step 1:'
'Enter first name into the "FName" text box'
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_FirstName'), 'FName')

'Step 2:'
'Enter last name into the "LName" text box'
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_LastName'), 'LName')

'Step 3:'
'Enter email into the "Email" text box'
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_Email'), 'test@gmail.com')

'Step 4:'
'Enter comment into the "Comment" text box'
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txa_Comment'), 'This is a comment')

'Step 5:'
'Click the "Submit" button'
WebUI.click( findTestObject('Object Repository/ContactUs_Page/btn_Submit'))
// Verify "Thank you for your message!" is displyed after send contact

'Step 6:'
'Verify The message "Thank You for your Message!" should be displayed.'
WebUI.verifyTextPresent("Thank You for your Message!", false)
WebUI.closeBrowser()