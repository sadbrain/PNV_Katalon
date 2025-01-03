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
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory

'Pre-condition steps: '
'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_HEROKU)
'step 1: '
'navigate to Drag And Drop page'
WebUI.click(findTestObject('Object Repository/Heroku_Page/lnk_DragAndDrop'))

//Locate the elements for Column A and Column B
WebElement dragElement = WebUI.findWebElement(findTestObject('Object Repository/Drag_And_Drop_Page/div_DragA'))
WebElement dropElement = WebUI.findWebElement(findTestObject('Object Repository/Drag_And_Drop_Page/div_DropB'))

'step 2: '
'Use Selenium Actions to perform the drag-and-drop operation'
Actions action = new Actions(DriverFactory.getWebDriver())
action.dragAndDrop(dragElement, dropElement).build().perform()

// Verify the text of Column A and Column B after the drag-and-drop action
String textAfterA = WebUI.getText(findTestObject('Object Repository/Drag_And_Drop_Page/div_DragA'))
String textAfterB = WebUI.getText(findTestObject('Object Repository/Drag_And_Drop_Page/div_DropB'))

'Assert that the text has swapped, indicating a successful drag-and-drop'
WebUI.verifyNotEqual(textAfterA, "A", FailureHandling.STOP_ON_FAILURE)
WebUI.verifyNotEqual(textAfterB, "B", FailureHandling.STOP_ON_FAILURE)

'Clean-up steps:'
WebUI.closeBrowser()