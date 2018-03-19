# JJATM
ATM Using Spring Boot and Rest with Tomcat Server

Hi,

Building & Running
__________________
To build this ATM project either run it with a machine that has Maven and Java 8 installed with the command 
    >mvn package && java -jar target/jj-atm-application-0.1.0.jar

Use
___________________
For testing I used Postman or SOAPUI (CURL had trouble with the JSON responses). 

For Withdrawls (POST): 
  Postman use 'localhost:8080/withdrawal?accId=123456789&pin=1234&amount=55'  

For Balances (GET)
  Postman use 'localhost:8080/balance?accId=123456789&pin=1234'  

Sample Output
__________________
{
    "fifties": 0,
    "twenties": 0,
    "tens": 0,
    "fives": 0,
    "message": "Transaction complete",
    "balance": 800
}

{
    "fifties": 0,
    "twenties": 0,
    "tens": 0,
    "fives": 0,
    "message": "Account not found with these credentials",
    "balance": 0
}


Testing
___________________
JUnits also included. These will be fired off once the mvn package command.


Best Regards,
John
