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
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Click on the "File Upload" link to navigate to the file upload page'
WebUI.click(findTestObject('Object Repository/FileUpload_Page/lnk_FileUpload'))

'Verify that the File Uploader header title is displayed on the page'
WebUI.verifyTextPresent('File Uploader', false)

'Upload a file using the "Choose File" input field'
WebUI.uploadFile(findTestObject('Object Repository/FileUpload_Page/input_ChooseFile'), file)

'Click the "Upload" button to initiate the file upload process'
WebUI.click(findTestObject('Object Repository/FileUpload_Page/btn_Upload'))

'Retrieve the text displayed on the page after the file is uploaded'
outputFile = WebUI.getText(findTestObject('Object Repository/FileUpload_Page/text'))

'Print the retrieved text to the console for debugging purposes'
System.out.print(outputFile + '*******')

'Split the file path to extract the file name'
String[] files = file.split('\\\\')

'Print the extracted file name to the console for debugging purposes'
System.out.println((files[(files.length - 1)]) + '******')

'Verify that the uploaded file name matches the displayed text on the page'
WebUI.verifyElementText(findTestObject('FileUpload_Page/text'), files[(files.length - 1)])

'Close browser'
WebUI.closeBrowser()

