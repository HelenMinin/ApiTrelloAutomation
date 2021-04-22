import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Scripts {
	@Given("Tenha um Board criado com listas")
	public void tenha_um_Board_criado() {

		CustomKeywords.'Criar.CriarBoard'()
		GlobalVariable.IdList = GlobalVariable.Retorno.get("id")
	}

	@When("Efetue uma requisição POST no endpoint de criação de Card passando a autenticação")
	public void efetue_uma_requisição_POST_no_endpoint_de_criação_de_Card_passando_a_autenticação() {

		CustomKeywords.'Criar.CriarCard'()
	}

	@Then("O Card deve ser criado na lista desejada")
	public void o_Card_deve_ser_criado_na_lista_desejada() {

		CustomKeywords.'Consultar.ConsultarCard'()

		if(GlobalVariable.Retorno.get("idBoard") != GlobalVariable.IdBoard){
			KeywordUtil.markWarning("" + GlobalVariable.Retorno.get("idBoard"))
			KeywordUtil.markWarning("" + GlobalVariable.IdBoard)
			KeywordUtil.markFailed("Card criado no board errado!")
		}
	}

	@Given("Possua o card criado")
	public void possua_o_card_criado() {

		if(GlobalVariable.idCard == ""){
			KeywordUtil.markFailed("Não possui nenhum card para ser editado")
		}

		KeywordUtil.markWarning("" + GlobalVariable.idCard)
	}

	@When("Efetue uma requisição PUT com as auterações e sua autenticação")
	public void efetue_uma_requisição_PUT_informando_o_Card_que_deseja_alterar_a_alteração_e_sua_autenticação() {

		CustomKeywords.'Editar.EditarCard'()
	}

	@Then("O card deve ser alterado respeitando as alterações informada na requisição")
	public void o_card_deve_ser_alterado_respeitando_as_alterações_informada_na_requisição() {

		CustomKeywords.'Consultar.ConsultarCard'()

		if(GlobalVariable.Retorno.get("name") != "CARD AUTOMATIZADO ALTERADO"){
			KeywordUtil.markWarning("" + GlobalVariable.Retorno.get("idBoard"))
			KeywordUtil.markWarning("" + GlobalVariable.Retorno.get("name"))
			KeywordUtil.markFailed("Card não possui o nome alterado!")
		}

		KeywordUtil.markWarning("" + GlobalVariable.Retorno.get("idBoard"))
		KeywordUtil.markWarning("" + GlobalVariable.Retorno.get("name"))
	}

	@When("Efetue uma requisição DELET informando o Card que deseja excluir e sua autenticação")
	public void efetue_uma_requisição_DELET_informando_o_Card_que_deseja_excluir_e_sua_autenticação() {

		CustomKeywords.'Excluir.ExcluirCard'()
		CustomKeywords.'Excluir.ExcluirBoard'()
	}

	@Then("O card deve ser excluido")
	public void o_card_deve_ser_excluido() {
		
		CustomKeywords.'Consultar.ConsultarCardInexistente'()
		if(GlobalVariable.StatusCode == 404){
			KeywordUtil.markPassed("Card excluido!")
			return
		}
		KeywordUtil.markError("StatusCode: " + GlobalVariable.StatusCode)
	}
	
	@Then("O Board em que o card foi criado tambem deve ser excluido")
	public void o_Board_em_que_o_card_foi_criado_tambem_deve_ser_excluido() {
		
		CustomKeywords.'Consultar.ConsultarBoardInexistente'()
		if(GlobalVariable.StatusCode == 404){
			KeywordUtil.markPassed("Board excluido!")
			return
		}
		KeywordUtil.markError("StatusCode: " + GlobalVariable.StatusCode)
	}
}