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

'Step 1'
'Open brower and navigate to url'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/drag_and_drop')

'Step 2'
'Verify header title is "Drag and Drop "'
WebUI.verifyTextPresent('Drag and Drop', false)

'Step 3'
'Drag and Drop column A to column B'
WebUI.dragAndDropToObject(findTestObject('Object Repository/005 - Verify Drag and Drop/div_ColumA'), findTestObject('Object Repository/005 - Verify Drag and Drop/div_ColumB'))

String jsDragAndDrop = '''
    function triggerDragAndDrop(selectorDrag, selectorDrop) {
        const elementDrag = document.querySelector(selectorDrag);
        const elementDrop = document.querySelector(selectorDrop);
        const dataTransfer = new DataTransfer();
        
        const dragStartEvent = new DragEvent('dragstart', { dataTransfer });
        const dropEvent = new DragEvent('drop', { dataTransfer });
        const dragEndEvent = new DragEvent('dragend', { dataTransfer });

        elementDrag.dispatchEvent(dragStartEvent);
        elementDrop.dispatchEvent(dropEvent);
        elementDrag.dispatchEvent(dragEndEvent);
    }
    triggerDragAndDrop('#column-a', '#column-b');
'''
WebUI.executeJavaScript(jsDragAndDrop, null)

'Step 4: Verify the positions of the columns after drag-and-drop'
boolean isColumnASwapped = WebUI.verifyElementText(findTestObject('Object Repository/005 - Verify Drag and Drop/div_ColumA'), 'B', FailureHandling.CONTINUE_ON_FAILURE)
boolean isColumnBSwapped = WebUI.verifyElementText(findTestObject('Object Repository/005 - Verify Drag and Drop/div_ColumB'), 'A', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment("Column A swapped: " + isColumnASwapped)
WebUI.comment("Column B swapped: " + isColumnBSwapped)

WebUI.closeBrowser()
