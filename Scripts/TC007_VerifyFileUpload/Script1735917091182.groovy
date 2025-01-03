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

String imgPath = "C:\\Users\\Ho Mai Huyen\\Downloads\\cat1.jpg"

'Get file name from path'
File imgFile = new File(imgPath)
String imgName = imgFile.getName()

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/upload')

//WebUI.click(findTestObject('Object Repository/File_Upload_Page/lnk_FileUpload'), FailureHandling.CONTINUE_ON_FAILURE)


String title = WebUI.getText(findTestObject('Object Repository/File_Upload_Page/h3_Title'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(title, 'File Uploader', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uploadFile(findTestObject('Object Repository/File_Upload_Page/btn_ChooseFile'), imgPath, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/File_Upload_Page/btn_Upload'), FailureHandling.CONTINUE_ON_FAILURE)

String uploadedTitle = WebUI.getText(findTestObject('Object Repository/File_Upload_Page/h3_Title'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(uploadedTitle, 'File Uploaded!', FailureHandling.CONTINUE_ON_FAILURE)

String displayedFileName = WebUI.getText(findTestObject('Object Repository/File_Upload_Page/img_File'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(displayedFileName, imgName, FailureHandling.STOP_ON_FAILURE)
