Feature: Edições de card

  @Editar
  Scenario: O usuário deve editar um card
    Given Possua o card criado
    When Efetue uma requisição PUT com as auterações e sua autenticação
    Then O card deve ser alterado respeitando as alterações informada na requisição
