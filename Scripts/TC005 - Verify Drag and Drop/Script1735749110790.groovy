import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions

// Step 1: Open browser and navigate to 'Drag and Drop' page
WebUI.openBrowser('')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

// Step 2: Click on the "Drag and Drop" link to access the Drag and Drop page
WebUI.click(findTestObject('Object Repository/TC005 - Verify Drag and Drop/DragAndDrop'))



// Kéo và thả từ phần tử A sang phần tử B
WebUI.dragAndDropToObject(findTestObject('Object Repository/TC005 - Verify Drag and Drop/BoxA'),
							findTestObject('Object Repository/TC005 - Verify Drag and Drop/BoxB')			   )

// Đợi một chút để đảm bảo rằng nội dung đã được cập nhật
WebUI.delay(1)

// Kiểm tra nội dung của phần tử sau khi drag and drop
String textA = WebUI.getText(findTestObject('Object Repository/TC005 - Verify Drag and Drop/txt_TextBoxB')) // Nội dung của B
String textB = WebUI.getText(findTestObject('Object Repository/TC005 - Verify Drag and Drop/txt_TextBoxA')) // Nội dung của A

// Kiểm tra xem nội dung đã được hoán đổi chưa
WebUI.verifyEqual(textA, 'B')
WebUI.verifyEqual(textB, 'A') 

