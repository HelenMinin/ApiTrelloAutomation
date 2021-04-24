package requisicao

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.After

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import internal.GlobalVariable

public class Requisicao {

	public static void EfetuarRequisicao(String endpoint){

		def requisicao = WS.sendRequest(findTestObject(endpoint))
		def xml = requisicao.getResponseText().split(" ")
		KeywordUtil.markWarning("" + xml)

		int codretorno = requisicao.getStatusCode()
		GlobalVariable.StatusCode = codretorno
		
		if(codretorno != 200){
			GlobalVariable.Retorno = xml
			return
		}
		
		def retorno = requisicao.getResponseText()

		JsonSlurper slurper = new JsonSlurper()

		def parsedJson = slurper.parseText(retorno)

		GlobalVariable.Retorno =  parsedJson;
	}

	public static void EfetuarRequisicaoSemRetorno(String endpoint){

		def requisicao = WS.sendRequest(findTestObject(endpoint))
		def xml = requisicao.getResponseText().split(" ")

		int codretorno = requisicao.getStatusCode()
		GlobalVariable.StatusCode = codretorno
	}
}
