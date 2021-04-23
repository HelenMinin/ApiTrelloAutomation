<h3 align="center">
    <img alt="Logo" title="#logo" width="300px" src="https://upload.wikimedia.org/wikipedia/commons/a/a6/Katalon_Studio_logo.png">
    <br><br>
    <b>Automação com Katalon</b>  
    <br>
</h3>

# Índice
- [Sobre](#sobre)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Usar](#como-usar)
- [Como Contribuir](#como-contribuir)

<a id="sobre"></a>
## :bookmark: Sobre
O ApiTrelloAutomation tem como objetivo executar processos da ferramenta Trello de forma automática! Nesse projeto é possível:
### :black_medium_square: Criar um Card: 
Para efetuar a criação de um card, é necessário possuir um board, com isso, antes do card é gerado um board. Por padrão, um novo board já possui 3 listas iniciais. O card será criado dentro da primeira lista do board!
### :black_medium_square: Editar um card criado: 
Para que um card possa ser editado é preciso, primeiramente, possuir um card. Devido a isso, o processo de criação de card se repete antes de sua edição!
### :black_medium_square: Excluir um card: 
Novamente, para se excluir um card é preciso que o mesmo já exista. Assim como na edição, um processo é executado antes da exclusão, sendo ele a edição. Ela é executada nesse exemplo para garantir que mesmo que o card seja editado, seja possível efetuar a sua exclusão!
Falando em exclusão, alem do card, o board também é excluído para que não fique "lixo" no Trello.

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
  2. No Katalon, abra o repositório;
  3. Na pasta `Profiles`, informe sua [chave de acesso e seu token](https://trello.com/app-key);
  4. Na pasta `Test Cases` selecione o teste desejado;
  5. Clique no botão `Executar` no canto superior direito.

<a id="como-contribuir"></a>
## :recycle: Como contribuir

- Faça um Fork desse repositório,
- Crie uma branch com a sua feature: `git checkout -b my-feature`
- Commit suas mudanças: `git commit -m 'feat: My new feature'`
- Push a sua branch: `git push origin my-feature`
## :memo: License

Esse projeto está sob a [LICENSE MIT](LICENSE).

<h4 align="center">
    Feito com 💜 by <a href="https://www.linkedin.com/in/helenminin/" target="_blank">Hélen Minin</a>
</h4>

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