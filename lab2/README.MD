Servlet:

É uma classe java que corre no servidor para receber e responder a requests ( http ).
Normalmente é multi-threaded para poder responder a vários pedidos ao mesmo tempo.


Tomcat:

Servidor web e container de servlets, permitindo dar deploy e correr aplicações web.
Faz parte do Jakarta EE, que contem varios serviços para aplicações web escritas em java, como servlets, JSP, JSF, JPA, etc.


SpringBoot:

Ferramenta da Spring, que facilita o desenvolvimento de aplicações web em java.
Permite criar aplicações web com o minimo de configuração, e com um servidor web embutido ( Tomcat, Jetty, etc ).
Permite também criar aplicações web com REST APIs, entre outros.

https://start.spring.io - Site para criar um projeto SpringBoot com as dependencias que queremos.

Para correr o springboot :
$ mvn install -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar
or
$ ./mvnw spring-boot:run

O springboot usa decoradores para definir as rotas, e o que fazer quando se recebe um pedido nessa rota. ( @GetMapping, @PostMapping, etc )
Dá para definir rotas com variaveis e se são obrigatorias ou não e valores default.

O thymeleaf é um template engine, que permite criar templates html com variaveis, e depois preencher essas variaveis com valores.






