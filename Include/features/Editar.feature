Feature: Title of your feature
  I want to use this template for my feature file

  @Editar
  Scenario: O usuário deve editar esse card.
    Given Possua o card criado
    When Efetue uma requisição PUT com as auterações e sua autenticação
    Then O card deve ser alterado respeitando as alterações informada na requisição
