import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Step 1: Open the browser and navigate to the URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com')

// Step 2: Click on the 'File Upload' link
WebUI.click(findTestObject('Object Repository/TC007 - Verify File Upload/lnk_FileUpload'))

// Step 3: Upload the file
String filePath = 'C:\\aaa.png'  // Path to the file to be uploaded
WebUI.uploadFile(findTestObject('Object Repository/TC007 - Verify File Upload/dlg_ChoseFile'), filePath)

// Step 4: Click on the 'Upload' button
WebUI.click(findTestObject('Object Repository/TC007 - Verify File Upload/btn_Upload'))

// Step 5: Verify the success message (check if the uploaded file name is present)
WebUI.verifyTextPresent('aaa.png', false)  // Ensure the uploaded file name appears in the success message
