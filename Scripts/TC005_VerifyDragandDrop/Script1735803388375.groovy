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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebDriver


WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')
WebUI.click(findTestObject('Object Repository/Verify_DragAndDrop/lb_DragAndDrop'))
WebUI.verifyElementText(findTestObject('Object Repository/Verify_DragAndDrop/lbl_HeaderTitle'), 'Drag and Drop')

WebDriver driver = DriverFactory.getWebDriver()

TestObject columnA = findTestObject('Object Repository/Verify_DragAndDrop/dragAndDrop_columnA')
TestObject columnB = findTestObject('Object Repository/Verify_DragAndDrop/dragAndDrop_ColumnB')

Actions actions = new Actions(driver)
actions.dragAndDrop(WebUI.findWebElement(columnA), WebUI.findWebElement(columnB)).perform()

WebUI.verifyElementText(findTestObject('Object Repository/Verify_DragAndDrop/dragAndDrop_columnA'), 'B')
WebUI.verifyElementText(findTestObject('Object Repository/Verify_DragAndDrop/dragAndDrop_ColumnB'), 'A')



