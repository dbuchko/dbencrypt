# dbencrypt

Demonstrate field level encryption using Credhub on PCF.

Based on:
https://spring.io/guides/gs/accessing-data-rest/
https://sultanov.dev/blog/database-column-level-encryption-with-spring-data-jpa/


To add a record:

`curl -i -H "Content-Type:application/json" -d '{"firstName": "Frodo", "lastName": "Baggins", "piiData": "secret-data"}' http://localhost:8080/people`


To fetch all the records:

`curl http://localhost:8080/people`

