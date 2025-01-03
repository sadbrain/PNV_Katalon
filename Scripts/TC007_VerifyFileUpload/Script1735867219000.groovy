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

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)

String imgPath = "C:\\Users\\Admin\\Pictures\\Screenshots\\Everfit.png"

File imgFile = new File(imgPath)
String imgName = imgFile.getName()

'Step 2: '
'Select File Upload link'
WebUI.click(findTestObject('Object Repository/Heroku_Page/lnk_FileUpload'), FailureHandling.CONTINUE_ON_FAILURE)

'Verify File Uploader header title is displayed'
String title = WebUI.getText(findTestObject('Object Repository/FileUpload_Page/h3_Title'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(title, 'File Uploader', FailureHandling.CONTINUE_ON_FAILURE)

'Step 3: '
'Click on Choose File button and upload a PNG file, then click Upload button'
WebUI.uploadFile(findTestObject('Object Repository/FileUpload_Page/btn_ChooseFile'), imgPath, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/FileUpload_Page/btn_Upload'), FailureHandling.CONTINUE_ON_FAILURE)

'Step 4: '
'Verify the h3 header changes after upload'
String uploadedTitle = WebUI.getText(findTestObject('Object Repository/FileUpload_Page/h3_Title'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(uploadedTitle, 'File Uploaded!', FailureHandling.CONTINUE_ON_FAILURE)

'verify name file after uploading'
String displayedFileName = WebUI.getText(findTestObject('Object Repository/FileUpload_Page/img_File'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(displayedFileName, imgName, FailureHandling.STOP_ON_FAILURE)

'Clean-up steps:'
WebUI.closeBrowser()