<h1 align="center"> Sistema Leilão </h1>

# Sobre o projeto

O sistema cadastrará usuários para que, uma vez logados, cadastrem itens para colocá-los em leilão, sendo possível ao dono do respectivo item a ser leiloado excluí-lo da base de dados se assim quiser. 
Os demais usuários, previamente cadastrados em sistema, poderão dar lances nos itens, assim como criar seus próprios leilões de itens e excluí-los também.

<h2>Regras</h2>

  1. [OUT] O sistema informa uma listagem de itens destinados a leilão com: nome do produto, data de abertura do leilão, valor inicial e o usuário dono do item.

  2. [IN] O usuário anônimo pode se cadastrar no sistema informando: nome, username e password.
     
  3. [IN] O usuário anônimo pode logar no sistema.
     
  4. [IN] O usuário logado pode cadastrar os itens que deseja colocar em leilão clicando em 'Novo Leilão'. Neste momento, deve informar: nome do produto, valor inicial e data da abertura. O nome do usuário estará auto preenchido pelo sistema.
     
  5. [OUT] O sistema informa uma listagem de itens destinados a leilão, entre eles, os cadastrados pelo usuário logado e os dos demais usuários anteriormente cadastrados.
     
  6. [IN] O usuário logado pode cadastrar um lance no sistema direcionado ao item que deseja arrematar clicando em 'Novo Lance'. Neste momento, deve informar: o valor do lance.

  7. [OUT] O sistema informa uma listagem com todos os lances dados para aquele determinado item, bem como, os nomes dos usuários responsáveis pelos lances.
     
  8. [IN] O usuário logado pode deletar o seu item colocado em leilão.
  
     **Informações complementares**

     - O campo data de abertura do leilão sempre deve conter uma data futura.

     - O campo valor inicial do leilão sempre deve conter um valor positivo.

     - O campo lance sempre deve conter um valor positivo.
    
     - Para as todas as validações do projeto foi utilizado @BeanValidation. Ademais, fora criado o tratamento de erro específico *MethodArgumentNotValidException* -erro 422- na camada de controlador *ControllerExceptionHandler*.
       
     - Há tratamento de erro caso exista exclusão por leilão não encontrado (por id). *ResourceNotFoundException* -erro 404- na camada de controlador *ControllerExceptionHandler*, tratamento em nível de controlador.
      

 ## Estrutura do Projeto (Back-end)
  * *src/main/java/com.nunessports.commerce/**controllers***: Os controladores do sistema (UsuarioController, LoginController, LeilaoController e LanceController).
  * *src/main/java/com.nunessports.commerce/controllers/**handlers***: Os tratamentos de erros em nível de controlador (anotação @ControllerAdvice).
  * *src/main/java/com.nunessports.commerce/controllers/**dtos***: Os DTOs do projeto, bem como, as classes que representam os erros e suas mensagens.
  * *src/main/java/com.nunessports.commerce/controllers/**entities***: As entidades mapeadas pela JPA. No sistema são três: Usuário, Leilão e Lance. Cada atributo da entidade corresponde a um campo na tabela no banco de dados.
  * *src/main/java/com.nunessports.commerce/controllers/**repositories***: Onde se encontram as interfaces UsuarioRepository, LeilaoRepository e LanceRepository, extensões da JPARepository capaz de fazer a ligação com o banco de dados.
  * *src/main/java/com.nunessports.commerce/controllers/**services***: Presentes as classes UsuarioService, LeilaoService e LanceService onde toda lógica é trabalhada para ser utilizada na camada de controlador, quando chamado.
  * *src/main/java/com.nunessports.commerce/controllers/services/**exceptions***: Presente a classe ResourceNotFoundException extensão de RuntimeException, para tratamento de erros sem a necessidade de utilização de try-catch.
  * *src/main/resources/**application.properties***: Arquivo de configuração do banco de dados local MySQL (como url do banco, username e password), configurações da JPA e SQL.

 ## Estrutura do Projeto (Front-end)
 * *src/pages/**css***: Presentes os arquivos responsáveis pela estilização do sistema (representação visual).
 * *src/pages/**images***: As imagens utilizadas no projeto.
 * *src/pages/**modules***: Onde estão os arquivos que trabalham a lógica do front-end, conexão com a API e os métodos HTTP de cada página da aplicação (Home, Login, Cadastro, Leilão e Lance).
 
 ## Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- MySQL
- SQL
- Maven
- Javascript
- React
- Html
- CSS

## Figma (Design)

<a href="https://www.figma.com/file/qT3RL8R1qemP3viq8C7UVr/Untitled?type=design&node-id=1-58&mode=design">Figma 1</a>

<a href="https://www.figma.com/file/272S0tjECIWKjCnsvvgcPr/Untitled?type=design&node-id=0-1&mode=design">Figma 2</a>

## Diagrama de Classes

![diagrama_classes_leilao](https://github.com/user-attachments/assets/b1e82c67-473c-4172-a2ed-356ff5e47d3d)

## Diagrama de Casos de Uso

![DiagramaCasosDeUsoLeilao](https://github.com/larissa-cruz/projeto-leilao/assets/104517707/85e328f3-f0b6-4d6c-98f4-abaad2d60e93)

## Autores

Larissa da Cruz

<a href="https://www.linkedin.com/in/larissa-da-cruz-0ba314219/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

Leonardo Sales

<a href="https://www.linkedin.com/in/leonardo-sales-franca/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
