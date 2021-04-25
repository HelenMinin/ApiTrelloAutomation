Feature: Casos de exclusão

  @Excluir
  Scenario: O usuário deve excluir o card e também as sujeiras geradas por esta automação.
    Given Possua o card criado
    When Efetue uma requisição DELETE informando o Card que deseja excluir e sua autenticação
    Then O card deve ser excluido

  @ExcluirTodosBoardDaOrganizacao
  Scenario: O usuário deve excluir todos os board que estão dentro de uma organização
    Given Possua o ID da organização
    When Efetue uma requisição DELETE informando a organização que deseja excluir os card
    Then Todos os board da organização deve ser excluido

 @ExcluirCardNaoExiste
  Scenario: O usuário deve excluir um card que não existe
    Given Não possua um card criado
    When  Efetue uma requisição DELETE informando o Card que deseja excluir e sua autenticação
    Then Deve retornar o Status Code 404

  @CriarCardSemAutenticacao
  Scenario: O usuario deve editar um card sem possuir autenticação
    Given Não possua uma autenticação valida
    When Efetue uma requisição DELETE informando o Card que deseja excluir e sua autenticação invalida
    Then Deve retornar o Status Code 401