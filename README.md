# JJATM
ATM Using Spring Boot and Rest with Tomcat Server

Hi,

Building & Running
__________________
To build this ATM project either run it with a machine that has Maven and Java 8 installed with the command 
    >mvn package && java -jar target/jj-atm-application-0.1.0.jar

Use
___________________
For testing, CURL, Postman or SOAPUI (I used Curl and Postman). Response is in the form of JSON.

For Withdrawls (POST): 
  Postman use 'localhost:8080/withdrawal?accId=123456789&pin=1234&amount=55'  
  > curl localhost:8080/withdrawal?accId=123456789&pin=1234&amount=55 -X POST

For Balances (GET)
  Postman use 'localhost:8080/balance?accId=123456789&pin=1234'  
  > localhost:8080/balance?accId=123456789&pin=1234 -X GET

Testing
___________________
No time to add unit tests I'm afraid


Best Regards,
John
