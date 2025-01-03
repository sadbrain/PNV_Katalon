WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/Page_FileUpload/lnk_FileUpload'))
WebUI.verifyElementText(findTestObject('Object Repository/Page_FileUpload/hdr_FileUploader'), 'File Uploader')
String filePath = 'C:\\conmeo.png'
WebUI.uploadFile(findTestObject('Object Repository/Page_FileUpload/btn_ChooseFile'), filePath)
WebUI.click(findTestObject('Object Repository/Page_FileUpload/btn_submit'))
WebUI.verifyElementText(findTestObject('Object Repository/Page_FileUpload/disp_FileUploaded'), 'conmeo.png')
WebUI.closeBrowser() 
