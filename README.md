# Okay Bank

## Sobre

Aplicação do banco Okay Bank com registro de funcionários, agencias, contas, cartões, trasações e clientes.   

## Modelo

```mermaid
---
title: Okay Bank
---

classDiagram
    Account "*" -- "1" Customer : has
    
    Account "1" -- "*" AccountTransfer : has
    
    Transfer "1" -- "*" AccountTransfer : has
    
    Account "*" -- "1" Agency : has
    
    Customer "1" -- "*" Card : has
    
    Agency "1" -- "*" Employee : has
    
    Employee -- EmployeeType
     
    Customer -- CustomerType 
    
    Account -- AccountType 
     
    Customer -- Address
    
    Transfer -- TransferType
    
    Transfer -- Payer 
    
    Transfer -- Receiver 
    
    Card -- CardType 
    
    Employee -- Address
    
    class AccountTransfer  {
	    <<Entity>>
	    - String id
	    - Transfer transfer
	    - Account account
    } 
    
    class Account {
	    <<Entity>>
	    - String id
	    - String number
	    - BigDecimal balance
	    - LocalDate creationDate
	    - String password
	    - AccountType accountType
	    - Customer customer
	    - Agency agency
	    - List~AccountTransfer~ accountTransfers
    }
    
    class Customer {
	    <<Entity>>
	    - String id
	    - String document
	    - LocalDate birthDate
	    - String name
	    - String email
	    - Address address
	    - String phone
	    - CustomerType customerType
	    - List~Account~ accounts
	    - List~Card~ cards 
    }
    
    class Transfer {
	    <<Entity>>
	    - String id 
	    - Payer payer
	    - Receiver receiver
	    - BigDecimal value
	    - LocalDateTime transferDateAndTime
	    - TransferType transferType
	    - List~AccountTransfer~ accountTransfers       
    }
    
    class Card {
	    <<Entity>>
	    - String id
	    - String number
	    - String holder
	    - LocalDate validationDate
	    - String flag
	    - String cvv
	    - String password
	    - CardType cardType
	    - BigDecimal limit
	    - String agency
	    - String account
	    - Customer customer
    }
    
    class Agency {
	    <<Entity>>
	    - String id
	    - String number
	    - LocalDate creationDate
	    - List~Account~ accounts
	    - List~Employee~ employees 
    }
    
    class Employee {
	    <<Entity>>
	    - String id
	    - String matriculation
	    - LocalDate birthDate 
	    - String cpf
	    - String name
	    - BigDecimal salary
	    - Address address
	    - String email
	    - String phone
      - String password
	    - EmployeeType employeeType
	    - EmployeeStatus employeeStatus
	    - Agency agency
    }
    
    class EmployeeType {
	    <<Enum>>
	    BANKING,MANAGER; 
    }
    
    class CardType {
	    <<Enum>>
	    CREDIT, DEBIT;
    }
    
    class TransferType {
	    <<Enum>>
	    PIX,TED;
    }
    
    class CustomerType {
      <<Enum>>
	    PF, PJ;
    }
    
    class AccountType {
	    <<Enum>>
	    SAVINGS, CHECKING; 
    }
    
    class Payer {
	    - String name
	    - String document
	    - String institution
	    - String accountNumber
	    - String agencyNumber
    } 
    
    class Receiver {
	    - String name
	    - String document
	    - String institution
	    - String accountNumber
	    - String agencyNumber
    }        
    
    class Address {
	    - String postalCode
	    - String name
	    - Integer number
	    - String district
	    - String city
	    - String state
    }
```

# Recursos do projeto

## Frontend

- Angular
- TypeScript

## Backend

- Spring Boot
- Java
- PostgreeSQL
- H2DB
- Arquitetura Limpa

## Funcionalidade

- Registrar agência
- Atualizar agência pelo id
- Procurar agência pelo id
- Listar agências
- Deletar agência pelo id



