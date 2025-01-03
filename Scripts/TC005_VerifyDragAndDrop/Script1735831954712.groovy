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
import org.openqa.selenium.WebElement
// step 1 Go to https://the-internet.herokuapp.com/ and Select 'Drag and Drop' link

WebUI.openBrowser(GlobalVariable.URL_HERROKUAPP)
WebUI.click( findTestObject('Object Repository/DragAndDrop_Page/lnk_DragAndDrop'), FailureHandling.CONTINUE_ON_FAILURE)

//Locate the elements for Column A and Column B
WebElement dragElement = WebUI.findWebElement(findTestObject('Object Repository/DragAndDrop_Page/div_DragA') )
WebElement dropElement = WebUI.findWebElement(findTestObject('Object Repository/DragAndDrop_Page/div_DropB'))

// step 2: Drag and Drop column A to column B
WebUI.dragAndDropToObject(findTestObject('Object Repository/DragAndDrop_Page/div_DragA') , findTestObject('Object Repository/DragAndDrop_Page/div_DropB'), FailureHandling.CONTINUE_ON_FAILURE)

// Verify the text of Column A and Column B after the drag-and-drop action
String textAfterA = WebUI.getText(findTestObject('Object Repository/DragAndDrop_Page/div_DragA'))
String textAfterB = WebUI.getText(findTestObject('Object Repository/DragAndDrop_Page/div_DropB'))

// Assert that the text has swapped, indicating a successful drag-and-drop
WebUI.verifyNotEqual(textAfterA, "A", FailureHandling.STOP_ON_FAILURE)
WebUI.verifyNotEqual(textAfterB, "B", FailureHandling.STOP_ON_FAILURE)


WebUI.closeBrowser()