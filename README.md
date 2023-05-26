# agenda-barba
### Requirements:
- Maven (3.9.2)

### Running:
- <code>./mvnw spring-boot:run</code> in the root folder

### Geração de pacote para deploy
- mvn clean package na pasta raiz do projeto

### Fazendo deploy do arquivo .jar no servidor AWS
- chmod 400 ChaveIBarber2.pem
- scp -i "E:\aws\iBarberServer\ChaveIBarber2.pem" "E:\dev\agendabarbearia\agenda-barba\target\demo-0.0.1-SNAPSHOT.jar" ec2-user@ec2-18-223-171-183.us-east-2.compute.amazonaws.com:~