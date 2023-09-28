Maven:


- maven package para compilar e gerar o jar
- mvn exec:java -Dexec.mainClass="package.programa" para correr o programa
- mvn exec:java -Dexec.mainClass="package.programa" -Dexec.args="$args" para correr o programa com argumentos
- Run Java no vscode também funciona 



Docker:

- Docker compose up para correr
- Docker compose down para parar

dar build e run em images ( no dir do DockerFile ):

docker image build -t docker-java-jar:latest .
docker run docker-java-jar:latest


