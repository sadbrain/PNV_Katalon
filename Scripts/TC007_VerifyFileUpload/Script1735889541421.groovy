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


// Step 1 : Go to https://the-internet.herokuapp.com/
WebUI.openBrowser(GlobalVariable.MENU_URL)

// Select 'File Upload' link
WebUI.click(findTestObject('Object Repository/FileUpload_Page/lnk_FileUpload'))


WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/FileUpload_Page/lbl_FileUploadTitle')), "File Uploader")

// Step 2:  Click on 'Choose File' button and upload a png file 'Ex: c:\abc.png'
WebUI.uploadFile(findTestObject('Object Repository/FileUpload_Page/btn_ChooseFile'), "C:/Users/binh/Pictures/Screenshots/F5.png")

// Step 2 : Click on 'Upload' button
WebUI.click(findTestObject('Object Repository/FileUpload_Page/btn_Upload') )

String title = WebUI.getText(findTestObject('Object Repository/FileUpload_Page/lbl_FileUploadTitle'))

// Verify that the png file is upload successful
WebUI.verifyEqual(title, "File Uploaded!")

WebUI.closeBrowser()