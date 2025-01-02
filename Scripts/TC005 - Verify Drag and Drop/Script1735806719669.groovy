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
import customKeywords.DragAndDropUtils as DragAndDrop


"Step 1:"
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/drag_and_drop')
WebUI.verifyTextPresent('Drag and Drop', false)

"Step 2"
TestObject columnA = findTestObject('Object Repository/TC005 - Verify Drag and Drop/div_colum_a')
TestObject columnB = findTestObject('Object Repository/TC005 - Verify Drag and Drop/div_colum_b')

DragAndDrop.dragAndDropUsingJavaScript(columnA, columnB)

"Step 3"
WebUI.verifyElementText(columnA, 'B', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(columnB, 'A', FailureHandling.CONTINUE_ON_FAILURE)

"Step 4"
WebUI.closeBrowser()


