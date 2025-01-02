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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory


WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/DragandDropPage/lnk_DragAndDrop'))

WebUI.verifyElementText(findTestObject('Object Repository/DragandDropPage/txt_HeaderTitle'), 'Drag and Drop')

WebElement columnA = WebUI.findWebElement(findTestObject('Object Repository/DragandDropPage/column_A'))
WebElement columnB = WebUI.findWebElement(findTestObject('Object Repository/DragandDropPage/column_B'))

WebDriver driver = DriverFactory.getWebDriver()
Actions actions = new Actions(driver)

actions.dragAndDrop(columnA, columnB).perform()

WebUI.verifyElementText(findTestObject('Object Repository/DragandDropPage/column_A'), 'B')
WebUI.verifyElementText(findTestObject('Object Repository/DragandDropPage/column_B'), 'A')

WebUI.closeBrowser()
