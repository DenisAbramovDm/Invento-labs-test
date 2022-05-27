Requirements: java 17, PostgreSql (with databace *postingsdb*, user: *admin*, psw: *admin*;
user and password can be another and changed in *application.properties*; 
another settings like database url and names also can be changed in that file)
## Linux
1. open this folder in terminal
2. ```./mvnw clean install```
3. Run first task: ```java -jar IpConverter/target/IpConverter-0.1.jar```
4. Run second task: ```java -jar Tendency/target/Tendency-0.1.jar```
5. Run third task: 
   1. ```cd Postings```
   2. ```./mvnw spring-boot:run```
   3. Using Postman or InernetBrowser make GET queries:
   ```http://localhost:8080/``` to get all postings
   4. ```http://localhost:8080/?authorizedOnly=true``` to get only authorized postings

## Windows
The same actions but instead of ```./mvnw``` U should type ```mvnw.cmd```
