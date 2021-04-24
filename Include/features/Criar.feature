Feature: Criação de cards

  @Criar
  Scenario: O usuário deve criar um card
    Given Tenha um Board criado com listas
    When Efetue uma requisição POST no endpoint de criação de Card passando a autenticação e o nome do card
    Then O Card deve ser criado na lista desejada

  @CriarCardSemBoard
  Scenario: O usuario deve tentar criar um card dentro de um board que não existe
    Given Não possua um board criado
    When Efetue uma requisição POST no endpoint de criação de Card passando a autenticação
    Then Deve retornar o Status Code 404

  @CriarCardSemAutenticacao
  Scenario: O usuario deve tentar criar um card sem possuir autenticação valida
    Given Não possua uma autenticação valida
    When Efetue uma requisição POST no endpoint de criação de Card passando a autenticação invalida
    Then Deve retornar o Status Code 401
