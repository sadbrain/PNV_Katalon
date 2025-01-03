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

'Step 1'
'Open the browser and navigate to the URL'
WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/drag_and_drop')


WebElement dragElement = WebUI.findWebElement(findTestObject('Object Repository/TC005 - Verify Drag and Drop/div_colum_a'))
WebElement dropElement = WebUI.findWebElement(findTestObject('Object Repository/TC005 - Verify Drag and Drop/div_colum_b'))

'step 2: '
'Use Selenium Actions to perform the drag-and-drop operation'
Actions action = new Actions(DriverFactory.getWebDriver())
action.dragAndDrop(dragElement, dropElement).build().perform()

'Verify the text of Column A and Column B after the drag-and-drop action'
String textAfterA = WebUI.getText(findTestObject('Object Repository/TC005 - Verify Drag and Drop/div_colum_a'))
String textAfterB = WebUI.getText(findTestObject('Object Repository/TC005 - Verify Drag and Drop/div_colum_b'))

WebUI.verifyNotEqual(textAfterA, "A", FailureHandling.STOP_ON_FAILURE)
WebUI.verifyNotEqual(textAfterB, "B", FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()