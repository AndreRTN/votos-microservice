# votos-microservice
API para validar cpf e tópico kafka para resultado das votações

## Requisitos:

- Docker (Se não possuir o docker precisará baixar as dependências contidas nos arquivos compose.yml e configurar manualmente)

- JDK 17

## Para rodar o microservice responsável por validar o cpf e consumir o tópico de resultados 
 
Entre na pasta do projeto e em seguida na pasta do docker, digite "docker-compose -f kafka-docker-compose.yml -p kafka up"
Você terá o kafka rodando e a interface do kafdrop em localhost:19000

Agora siga os mesmos passos do projeto anterior, digite mvn package no terminal, irá gerar um .jar na pasta target,
" java -jar .\target\votos-microservice-0.0.1-SNAPSHOT.jar" para executar o microservice no localhost:8086 
(Necessário ter o container do kafka em execução)
