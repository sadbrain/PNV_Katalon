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

// step 1: Go to https://webdriveruniversity.com/Contact-Us/contactus.html
WebUI.navigateToUrl(GlobalVariable.CONTACT_URL)
// step 2: Set "FName" to the first name text box
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txt_FirstName') , 'FName')

// step 3: Set "LName" to the last name text box
WebUI.setText( findTestObject('Object Repository/ContactUs_Page/txt_LastName'), 'LName')

// step 4: Set "test@gmail.com" to the email text box
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txt_EmailAddress') , 'test@gmail.com')

// step 5: Set "This is a comment" to the comment text box
WebUI.setText(findTestObject('Object Repository/ContactUs_Page/txa_Comment'), 'This is a comment')

// step 6: Click Submit button
WebUI.click(findTestObject('Object Repository/ContactUs_Page/btn_Submit'))

// verify text Thank You for your Message!
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/ContactUs_Page/lbl_Message')) ,"Thank You for your Message!" , false)

WebUI.closeBrowser()