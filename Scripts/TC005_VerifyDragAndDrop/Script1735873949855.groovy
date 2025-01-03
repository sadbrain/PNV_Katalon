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
WebUI.navigateToUrl(GlobalVariable.HEROKUAPP)
WebUI.click(findTestObject('Object Repository/Verify_DragAndDrop/lnk_DragDrop'))

// Verify Header
String headerText = WebUI.getText(findTestObject('Object Repository/Verify_DragAndDrop/hdr_DrapDrop'))
WebUI.verifyMatch(headerText, 'Drag and Drop', false)

TestObject columnA = findTestObject('Object Repository/Verify_DragAndDrop/drg_ColumnA')
TestObject columnB = findTestObject('Object Repository/Verify_DragAndDrop/drg_ColumnB')

String script = """
    const dataTransfer = new DataTransfer();
    const source = arguments[0];
    const target = arguments[1];
    
    source.dispatchEvent(new DragEvent('dragstart', {dataTransfer}));
    target.dispatchEvent(new DragEvent('drop', {dataTransfer}));
    source.dispatchEvent(new DragEvent('dragend', {dataTransfer}));
"""

WebUI.executeJavaScript(script, Arrays.asList(WebUI.findWebElement(columnA), WebUI.findWebElement(columnB)))

// Verify if column A has moved to B and column B has moved to A
String columnAContentAfterDrag = WebUI.getText(columnA)
String columnBContentAfterDrag = WebUI.getText(columnB)

// Validate that the content of A is now in B and B in A
WebUI.verifyMatch(columnAContentAfterDrag, 'B', false) 
WebUI.verifyMatch(columnBContentAfterDrag, 'A', false) 
