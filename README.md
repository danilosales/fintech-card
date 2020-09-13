# Projeto para Analise de concessão de crédito

A arquitetura do projeto foi montado utilizando as seguintes tecnologias:

* Spring Boot - para construção dos microserviços descritos abaixo
* H2 - Base de dados em memoria para persistência das propostas.
* Angular 8 com bootstrap 4 e PrimeNG - Para construção da interface visual
* Weka - para construção do motor de Machine Learning para analise das propostas
* Swagger - Usado para docuemntar os serviços


## Descrição dos projetos

#### analise-engine

Este projeto tem como objetivo carregar o modelo arrf criado a partir dos dados fornecidos e realizar a analise de novas propostas de solicitação de crédito. O mesmo disponbiliza um endpoint para que se possa solicitar esta analise.

#### fintech-server

Este projeto tem como objetivo fornecer uma API para comunicação direta com possíveis entradas de usuário (Mobile, Web). É disponibilizado um endpoint com os métodos disponíveis. Este projeto se comunica diretamente com o analise-engine.

#### fintech-server

Este projeto é responsável pelo frontend, o mesmo foi desenvolvido usando Angular 8, bootstrap 4 e PrimeNG, este projeto faz uso direto das APIs disponibilizadas pelo fintech-server.


## Instruções para executar o projeto


Após realizar o download do projeto, executar os seguintes comandos:

```sh
 mvn clean package
```
Este comando acima irá compilar os pacotes das aplicações java, em seguida acesse a pasta fintech-front e execute o comando abaixo para baixar as dependencias do projeto frontend

```sh
npm install
```

Após o término da execução voltar para a raiz principal do projeto e executar o comando:

```sh
docker-compose up
```

Caso deseje que se execute em background adicionar o parametro -d ao final:

```sh
docker-compose up -d
```

Caso seje necesário refazer o build utilizar o seguinte comando:

```sh
docker-compose up --build
```


Este comando irá subir todas as imagens dos projetos em containers dockers.

Endereços disponíveis:

* [Documentação serviços engine de analise de crédito](http://localhost:9080/swagger-ui.html)

* [Documentação serviços para o frontend](http://localhost:8080/swagger-ui.html)

* [Aplicação frontend](http://localhost)


#### Considerações Finais

* A quantidade de dados fornecidos não é suficiente para garantir a precisão do algoritmo com outros dados, como não havia descrito regras de negócios claras sobre a aprovação não foi possível gerar outra massa de testes válida.

* Em relação ao projeto analise-engine, o correto é termos um outro projeto que seja responsavel somente em gerar o modelo para ser usado pelo weka, visto que a quantidade de dados para avaliação pode tornar o processamento lento de novas analises, pois dependendo do tamanho da matriz ele pode levar um certo tempo até processar toda a matriz de probabilidade.

* Em casos que o serviço de analise esteja offline, foi criado um novo status "Em analise" para que posteriormente seja processado, para isto o kafka iria auxiliar com os que não foram processados, para que quando o serviço estivesse online fosse processado.
