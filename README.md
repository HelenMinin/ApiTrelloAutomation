# Índice

- [Sobre](#sobre)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Usar](#como-usar)
- [Como Contribuir](#como-contribuir)

<a id="sobre"></a>
## :bookmark: Sobre

<a id="tecnologias-utilizadas"></a>
## :rocket: Tecnologias Utilizadas
* [Katalon v7.7.2](https://github.com/katalon-studio/katalon-studio/releases/tag/v7.7.2)
* [Gherkin](https://cucumber.io/docs/gherkin/reference/)

<a id="como-usar"></a>
## :fire: Como usar
* Pré-requisitos
  * É necessario ter instalado o [Katalon v7.7.2](https://github.com/katalon-studio/katalon-studio/releases/tag/v7.7.2).

* Executando os testes
  1. Clone o projeto em sua maquina: 
      ```sh
        $ git clone https://github.com/HelenMinin/ApiTrelloAutomation.git
      ```
  2. No Katalon, abra o repositório
  3. Na pasta `Test Cases`, se encontra casos de testes disponiveis
  4. Clique no botão `Executar` no canto superior direito do teste desejado



## Autenticação
  Para autenticar no trello, precisa da chave e do token, que podem ser adquiridos pelo [link](https://trello.com/app-key)

## Criação de card
Para criar um card é preciso efetuar uam requisição POST
```
https://api.trello.com/1/cards?key={Key}&token={Token}&idList={Id da lista}
```
Para conseguir o ID de uma lista, eu consultei um card que pertencia a lista na qual eu queria inserir o novo card, com isso, no campo "idList" do Json de retorno eu consegui a informação que eu desejava

## Editar card
Uma vez que o Card é criado, no JSOON de retorno da ciação, o campo "shortLink" eu encontro o ID do card que eu acabei de criar, com ele eu posso efetuar a edição que eu desejo atravez da requisição PUT
```
https://api.trello.com/1/cards/{id}?key={Key}&token={Token}
```