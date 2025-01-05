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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebDriver

'Open the browser and navigate to the URL'
WebUI.openBrowser(GlobalVariable.URL_INTERNET)

'Verify the presence of the Drag and Drop link and click on it'
WebUI.click(findTestObject('Object Repository/DragAndDrop_Page/lnk_DragAndDropTitle'))

'Verify the header Drag and Drop is present'
WebUI.verifyTextPresent('Drag and Drop', false)

'Get the WebDriver object'
WebDriver driver = DriverFactory.getWebDriver()

'Create an Actions object to perform drag-and-drop action'
Actions actions = new Actions(driver)

'Identify the columnA and columnB elements'
TestObject columnA = findTestObject('Object Repository/DragAndDrop_Page/fra_columnA')
TestObject columnB = findTestObject('Object Repository/DragAndDrop_Page/fra_columnB')

'Perform the drag-and-drop action'
actions.dragAndDrop(WebUI.findWebElement(columnA), WebUI.findWebElement(columnB)).build().perform()

'Verify that the text in columnA and columnB has correctly changed after the drag-and-drop'
WebUI.verifyElementText(findTestObject('Object Repository/DragAndDrop_Page/fra_columnA'), 'B')
WebUI.verifyElementText(findTestObject('Object Repository/DragAndDrop_Page/fra_columnB'), 'A')

'Close the browser'
WebUI.closeBrowser()






