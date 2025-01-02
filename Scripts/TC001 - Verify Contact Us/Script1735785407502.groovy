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
WebUI.navigateToUrl('https://webdriveruniversity.com/Contact-Us/contactus.html')

"Step 1"
"Enter text to First Name"
WebUI.setText( findTestObject('Object Repository/TC001 - Verify Contact Us/txt_FirstName'), 'FName', FailureHandling.CONTINUE_ON_FAILURE)

"Step 2"
"Enter text to Last Name"
WebUI.setText( findTestObject('Object Repository/TC001 - Verify Contact Us/txt_LastName'), 'LName', FailureHandling.CONTINUE_ON_FAILURE)

"Step 3"
"Enter text Email"
WebUI.setText(findTestObject('Object Repository/TC001 - Verify Contact Us/txt_Email') , 'test@gmail.com', FailureHandling.CONTINUE_ON_FAILURE)

"Step 4"
"Enter text Commnent"
WebUI.setText(findTestObject('Object Repository/TC001 - Verify Contact Us/txa_Comment') , 'This is a comment', FailureHandling.CONTINUE_ON_FAILURE)

"Step 5"
"Click on the Submit button"
WebUI.click(findTestObject('Object Repository/TC001 - Verify Contact Us/btn_Submit'), FailureHandling.CONTINUE_ON_FAILURE)

"ER"
'"Thank You for your Message!" text is displayed'
WebUI.verifyTextPresent('Thank You for your Message!', false, FailureHandling.CONTINUE_ON_FAILURE)


