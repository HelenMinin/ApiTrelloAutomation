@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @Excluir
 Scenario: O usuário deve excluir o card e também as sujeiras geradas por esta automação.
    Given Possua o card criado 
    When Efetue uma requisição DELET informando o Card que deseja excluir e sua autenticação
    Then O card deve ser excluido
    And O Board em que o card foi criado tambem deve ser excluido