# api-shop-products
Projeto para api envolvendo, customeres, produtos e compras

O api de contruída usando SpringBoot 3.4.0 com os seguintes comandos:

```
curl -s https://get.sdkman.io | bash
source "/home/diego.costas/.sdkman/bin/sdkman-init.sh"=
sdk install springboot
spring version
spring init --dependencies=web,data-jpa api-shop-products --build=maven
```

Criar diretório .mvn/wrapper, criar um arquivo chamado maven-wrapper.properties e colocar dentro o seguinte conteúdo
```
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.8.6/apache-maven-3.8.6-bin.zip
wrapperUrl=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.1.0/maven-wrapper-3.1.0.jar
```

Copiar as seguintes linhas no arquivo src/main/resurces/application.properties, isso cria o DataBase H2

```
spring.datasource.url=jdbc:h2:file:/home/diego/Dev/java/api-shop-products/data/db-shop-products
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

Inicialização do projeto deve ser executada com o comando:

```
./mvnw spring-boot:run
```


Foram adicionadas 3 Entidades para mapear com dados com JPA:
```
Customer
Product
Purchase
```
