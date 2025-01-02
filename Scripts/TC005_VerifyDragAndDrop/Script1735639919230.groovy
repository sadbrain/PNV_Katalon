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
import com.kms.katalon.core.testobject.TestObject
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

// 2. Nhấn vào liên kết 'Drag and Drop'
WebUI.click(findTestObject('Object Repository/Page_DragAndDrop/lik_DragAndDrop'))

// 3. Kiểm tra tiêu đề của trang
WebUI.verifyTextPresent('Drag and Drop', false)

// 4. Kéo và thả cột A vào vị trí của cột B
WebElement columnA = WebUI.findWebElement(findTestObject('Object Repository/Page_DragAndDrop/col_ColumnA'))
WebElement columnB = WebUI.findWebElement(findTestObject('Object Repository/Page_DragAndDrop/col_ColumnB'))

WebDriver driver = DriverFactory.getWebDriver()
Actions actions = new Actions(driver)

// Thực hiện kéo và thả
actions.dragAndDrop(columnA, columnB).perform()

// 5. Xác minh kết quả sau khi kéo thả
WebUI.verifyElementText(findTestObject('Object Repository/Page_DragAndDrop/col_ColumnA'), 'B')
WebUI.verifyElementText(findTestObject('Object Repository/Page_DragAndDrop/col_ColumnB'), 'A')

// 6. Đóng trình duyệt
WebUI.closeBrowser()