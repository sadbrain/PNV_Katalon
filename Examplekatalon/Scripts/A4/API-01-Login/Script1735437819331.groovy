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

'step 1'
'send POST request:'
response =WS.sendRequest(findTestObject('Object Repository/A4/POST_Login'),FailureHandling.CONTINUE_ON_FAILURE)


'step 2'
'Verify response Status Code is correctly  '
 WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)

'step 3'
'Verify Token node has value '
 WS.verifyNotEqual(WS.getElementPropertyValue(response, 'token'),null, FailureHandling.CONTINUE_ON_FAILURE)


 'step 4'
 'Get Token value to use for below test case'
  GlobalVariable.TOKEN = WS.getElementPropertyValue(response, 'token',FailureHandling.CONTINUE_ON_FAILURE)
 

