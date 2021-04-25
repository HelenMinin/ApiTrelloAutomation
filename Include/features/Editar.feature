Feature: Edições de card

  @Editar
  Scenario: O usuário deve editar um card
    Given Possua o card criado
    When Efetue uma requisição PUT com as auterações e sua autenticação
    Then O card deve ser alterado respeitando as alterações informada na requisição

  @EditarCardNaoExiste
  Scenario: O usuário deve editar um card que não existe
    Given Não possua um card criado
    When Efetue uma requisição PUT com as auterações e sua autenticação
    Then Deve retornar o Status Code 404

  @CriarCardSemAutenticacao
  Scenario: O usuario deve editar um card sem possuir autenticação
    Given Não possua uma autenticação valida
    When Efetue uma requisição PUT com as auterações e sua autenticação invalida
    Then Deve retornar o Status Code 401
