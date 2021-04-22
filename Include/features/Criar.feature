@tag
Feature: Criação de cards

  @Criar
  Scenario: O usuário deve criar um card
    Given Tenha um Board criado com listas
    When Efetue uma requisição POST no endpoint de criação de Card passando a autenticação
    Then O Card deve ser criado na lista desejada
