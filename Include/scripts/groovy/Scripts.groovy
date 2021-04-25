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
import com.sun.jna.platform.KeyboardUtils

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

		LimparVariaveisGlobal()
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

	@When("Efetue uma requisição DELETE informando o Card que deseja excluir e sua autenticação")
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

	@Given("Não possua um board criado")
	public void não_possua_um_board_criado() {

		LimparVariaveisGlobal()
		def listaInvalida = "6081fae8bd1b7c12ec69ba05"
		GlobalVariable.IdList = listaInvalida
	}

	@When("Efetue uma requisição POST no endpoint de criação de Card passando a autenticação e o nome do card")
	public void efetue_uma_requisição_POST_no_endpoint_de_criação_de_Card_passando_a_autenticação_e_o_nome_do_card() {

		CustomKeywords.'Criar.CriarCard'()
	}

	@Then("Deve retornar o Status Code {int}")
	public void deve_retornar_o_Status_Code(int statusCode) {

		if(GlobalVariable.StatusCode != statusCode){

			KeywordUtil.markFailed("Status code esperado: " + statusCode + " Status code retornado: " + GlobalVariable.StatusCode)
		}
	}

	@Given("Não possua uma autenticação valida")
	public void não_possua_uma_autenticação_valida() {

		LimparVariaveisGlobal()
		def tokenInvalido = "9eb76d9a9d02b8dd40c2f3e5df18556c831d4d1fadbe2c45f8310e6c93b5c548"
		def keyInvalida = "0471642aefef5fa1fa76530ce1ba4c85"

		GlobalVariable.Token = tokenInvalido
		GlobalVariable.Key = keyInvalida
	}

	@When("Efetue uma requisição POST no endpoint de criação de Card passando a autenticação invalida")
	public void efetue_uma_requisição_POST_no_endpoint_de_criação_de_Card_passando_a_autenticação_invalida() {

		def listaInvalida = "6081fae8bd1b7c12ec69ba05"

		GlobalVariable.IdList = listaInvalida
		CustomKeywords.'Criar.CriarCardSemAutenticacao'()
	}
	@Given("Possua o ID da organização")
	public void possua_o_ID_da_organozação() {

		LimparVariaveisGlobal()
		GlobalVariable.idOrganizacao  = "60808868912ec3380115eaf5"
	}

	@When("Efetue uma requisição DELETE informando a organização que deseja excluir os card")
	public void efetue_uma_requisição_DELETE_informando_a_organização_que_deseja_excluir_os_card() {

		CustomKeywords.'Consultar.ConsultarTodosBoardOrganizacao'()
		CustomKeywords.'Excluir.ExcluirTodosBoard'()
	}

	@Then("Todos os board da organização deve ser excluido")
	public void todos_os_board_deve_ser_excluido() {

		CustomKeywords.'Consultar.ConsultarTodosBoardOrganizacao'()

		if (GlobalVariable.Retorno.toString() != "[]"){
			KeywordUtil.markError("Organização não esta vazia!")
		}
	}

	@Given("Não possua um card criado")
	public void não_possua_um_card_criado() {
		LimparVariaveisGlobal()
		def cardInexistente = "NuNurS4S"
		GlobalVariable.idCard = cardInexistente
	}

	@When("Efetue uma requisição PUT com as auterações e sua autenticação invalida")
	public void efetue_uma_requisição_PUT_com_as_auterações_e_sua_autenticação_invalida() {

		def cardInexistente = "NuNurS4S"
		GlobalVariable.idCard = cardInexistente
		CustomKeywords.'Editar.EditarCard'()
	}

	@When("Efetue uma requisição DELETE informando o Card que deseja excluir e sua autenticação invalida")
	public void efetue_uma_requisição_DELETE_informando_o_Card_que_deseja_excluir_e_sua_autenticação_invalida() {

		def cardInexistente = "NuNurS4S"
		def boardInvalido = "VLrjA7Ez"
		GlobalVariable.IdBoard = boardInvalido
		GlobalVariable.idCard = cardInexistente

		CustomKeywords.'Excluir.ExcluirCard'()
		CustomKeywords.'Excluir.ExcluirBoard'()
	}

	private void LimparVariaveisGlobal(){

		String variavelLimpa = ""

		GlobalVariable.IdBoard = variavelLimpa
		GlobalVariable.idCard = variavelLimpa
		GlobalVariable.IdList = variavelLimpa
		GlobalVariable.Retorno = variavelLimpa
		GlobalVariable.StatusCode = variavelLimpa
		GlobalVariable.idOrganizacao = variavelLimpa
		GlobalVariable.Token = ""
		GlobalVariable.Key = ""
	}
}