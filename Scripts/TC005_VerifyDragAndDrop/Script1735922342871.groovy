import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.security.auth.login.FailedLoginException

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

//  Step 1 : Go to https://the-internet.herokuapp.com/
WebUI.openBrowser(GlobalVariable.MENU_URL)

// Select 'Drag and Drop' link
WebUI.click(findTestObject('Object Repository/DragAndDrop_Page/lnk_DragAndDrop'))
WebUI.verifyEqual( WebUI.getText(findTestObject('Object Repository/DragAndDrop_Page/lbl_DragAndDropTitle')), "Drag and Drop")

// Step 2 : Drag and Drop column A to column B
TestObject boxA = findTestObject('Object Repository/DragAndDrop_Page/b_BoxA')
TestObject boxB = findTestObject('Object Repository/DragAndDrop_Page/b_BoxB')

WebUI.dragAndDropToObject(boxA, boxB)

// Verify that Box A and Box B have exchanged places
String boxATextAfter = WebUI.getText(boxA)
String boxBTextAfter = WebUI.getText(boxB)

WebUI.verifyEqual(boxATextAfter, "B", FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(boxBTextAfter, "A",  FailureHandling.CONTINUE_ON_FAILURE) 

WebUI.delay(2)

WebUI.closeBrowser()