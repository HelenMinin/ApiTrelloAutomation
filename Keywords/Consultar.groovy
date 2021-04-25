import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import internal.GlobalVariable
import requisicao.Requisicao

public class Consultar {

	@Keyword
	def ConsultarCard(){

		GlobalVariable.idCard = GlobalVariable.Retorno.get("shortLink")
		Requisicao.EfetuarRequisicao("Object Repository/Consultar Card")
	}

	@Keyword
	def ConsultarCardInexistente(){

		Requisicao.EfetuarRequisicaoSemRetorno("Object Repository/Consultar Card")
	}

	@Keyword
	def ConsultarBoardInexistente(){

		Requisicao.EfetuarRequisicaoSemRetorno("Object Repository/Consultar Board")
	}
	
	@Keyword
	def ConsultarTodosBoardOrganizacao(){

		Requisicao.EfetuarRequisicao("Object Repository/Consultar Board Da Organização")
	}
}
