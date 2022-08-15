
# REST API for Online Payment Wallet Application

We have create a REST API for online payment wallet application which can be used by customers for  different services like creating new wallet, add money into
wallet, deposit money to wallet, update their wallet by creating account or directly by login first if they are existing users. It's divided in different parts 
Bill payment section users can add different bill payment or view their view payment and in transaction session they can add ,view and do different transaction like
mobile recharge, gas bill payment, electric bill payment and many more transactions and bill payment services, they can also add , delete and view beneficiary before 
doing transaction from wallet.



### This is a collaborative project, completed by a team of 6 backend developers at Masai School.

# Collaborators

- [Shubham Kumar](https://www.github.com/codeirax)
- [Akash Kolte](https://www.github.com/akkii99)
- [Ritesh Kumar Jha](https://www.github.com/Riteshkumarjha98)
- [P.Murali Krishna](https://www.github.com/purimetlamuralikrishna)
- [Aadarsh Mukati](https://www.github.com/aadarsh11433)
- [Amit Prakash](https://www.github.com/amitprakash28)

# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven

# Modules

- Login Module
- Account Module
- Customer Module
- Bill Payment Module
- Transaction Module
- Beneficiary Module
- Bank Account Module

## Admin Features
- Admin can access all the services of wallet.

## User Features
- customer can validate their login.

## Customer Features
- Customer can login in the application and update their information using their username and password.
- Customer can add account to wallet.
- Customer can delete account from wallet.
- Customer can view account of wallet.
- Customer can view list of all account to wallet.

## Wallet Features
- First login in the application by using their username and password.
- Customer can create new wallet account.
- Customer can check balance of their wallet account.
- Customer can add money to  wallet account.
- Customer can update their wallet account.
- Customer can deposit amount from wallet account.


## Bill Payment Features
- Customer can add bill payment.
- Customer can view bill payment.


## Transaction Features
- Customer can add new transaction.
- Customer can view all transaction.
- Customer can view transaction by date.
- Customer can view lis of all transaction.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/walletdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```





