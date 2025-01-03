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

"Step 1"
"'File Uploader header title is displayed"
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/upload')
WebUI.verifyTextPresent('File Uploader', false)

"Step 2"
"The png file is upload successful"
WebUI.uploadFile(findTestObject('Object Repository/TC007 - Verify File Upload/btn_Choose File'), 'C:\\Users\\Lan Anh\\Pictures\\2023_06_17_21_32_IMG_2457.JPG')



'Step 4: Click the Upload button'
WebUI.click(findTestObject('Object Repository/TC007 - Verify File Upload/btn_Upload'))

' Optional: Add assertion to verify successful upload'
WebUI.verifyTextPresent('File Uploaded!', false)



