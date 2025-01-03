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

// Step 1 Go to https://the-internet.herokuapp.com/ and Select 'Key Presses' link
WebUI.openBrowser(GlobalVariable.URL_HERROKUAPP)
WebUI.click(findTestObject('Object Repository/KeyPresses_Page/lnk_KeyPress') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify 'Key Presses header title is displayed
WebUI.verifyElementText(findTestObject('Object Repository/KeyPresses_Page/h3_HeaderTitle') , 'Key Presses', FailureHandling.CONTINUE_ON_FAILURE)

// step 2: Presses 'TAB' key
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_Target') , Keys.chord(Keys.CONTROL, '\t'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText( findTestObject('Object Repository/KeyPresses_Page/p_Result'), 'You entered: TAB', FailureHandling.CONTINUE_ON_FAILURE)

// step 3: Presses 'ENTER' key
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_Target') ,Keys.chord(Keys.CONTROL, '\n'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText( findTestObject('Object Repository/KeyPresses_Page/p_Result'), 'You entered: ENTER', FailureHandling.CONTINUE_ON_FAILURE)

// step 4: Presses 'G' key
WebUI.sendKeys(findTestObject('Object Repository/KeyPresses_Page/txt_Target') ,Keys.chord(Keys.CONTROL, 'G'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText( findTestObject('Object Repository/KeyPresses_Page/p_Result'), 'You entered: G', FailureHandling.CONTINUE_ON_FAILURE)

// Close Browser
WebUI.closeBrowser()