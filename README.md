# okay-bank

# LICENSE
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/abnerjosefelixbarbosa/okay-bank/blob/main/LICENSE)

# About

Okay bank full stack app for performing banking services.

## Modeling

![imagem1](https://github.com/abnerjosefelixbarbosa/okay-bank/blob/main/assets/modelo_okay_bank.jpg)

# Features

- Login to the account by CPF and password

## Back end
- Java 17
- Spring boot
- JPA hibernate
- Maven
- MySQL
- Validation
- Lombok
- Junit
- Swagger

# Execução do Projeto
Pré-requisito: Java 17

## SQL
```SQL
INSERT INTO `db_okaybank`.`position`(`id`,`bonus`,`position`)VALUES('171a2940-ca07-47af-94a0-5c8a2779b155',null,'administrative agent');
INSERT INTO `db_okaybank`.`position`(`id`,`bonus`,`position`)VALUES('8bfd545f-e949-4b39-a535-39b7f186396e',0.2,'administrative manager');

INSERT INTO `db_okaybank`.`employee` (`id`, `matriculation`, `name`, `salary`, `position_id`) VALUES ('47d16014-f806-42d1-ab1c-ce3220ff5365', '1259358978', 'Fabiana Brito Guzzo', '3200.00', '171a2940-ca07-47af-94a0-5c8a2779b155');
INSERT INTO `db_okaybank`.`employee` (`id`, `matriculation`, `name`, `salary`, `position_id`) VALUES ('b2c9e7d5-eeb2-4470-877b-d47d4eb454a8', '2223455690', 'Olga Lucio Mello', '5500.00', '8bfd545f-e949-4b39-a535-39b7f186396e');

INSERT INTO `db_okaybank`.`agency` (`id`, `agency`, `employee_id`) VALUES ('4c055451-427d-4f06-a31e-ac9c07e8cad8', '1447552301', '47d16014-f806-42d1-ab1c-ce3220ff5365');
INSERT INTO `db_okaybank`.`agency` (`id`, `agency`, `employee_id`) VALUES ('807c21bb-ef6f-4f0e-8050-8b89225f092d', '2340445901', '47d16014-f806-42d1-ab1c-ce3220ff5365');

INSERT INTO `db_okaybank`.`customer` (`id`, `address`, `address_city`, `address_district`, `address_number`, `address_state`, `address_zip_code`, `birth_date`, `cpf`, `email`, `name`, `password`, `rg`, `telephone`, `employee_id`) VALUES ('87110d15-6340-4db1-8a14-63ea369a7df9', 'Rua Leovigildo Júnior', 'Recife', 'Casa Amarela', '113', 'PE', '52070-643', '1987-06-29', '623.388.714-30', 'luisa.valladares@gmail.com', 'Luisa Paes Valladares', '489562', '12.971.121', '(81) 99765-6483', '47d16014-f806-42d1-ab1c-ce3220ff5365');
INSERT INTO `db_okaybank`.`customer` (`id`, `address`, `address_city`, `address_district`, `address_number`, `address_state`, `address_zip_code`, `birth_date`, `cpf`, `email`, `name`, `password`, `rg`, `telephone`, `employee_id`) VALUES ('bc7b232c-b70f-4d3c-829a-2c47f22de952', 'Rua Tempero', 'Olinda', 'Guadalupe', '32', 'PE', '53320-571', '1996-05-14', '676.497.994-41', 'estefani.mattos@gmail.com', 'Estefani Prucho Mattos', '127596', '14.824.084', '(87) 97953-4972', '47d16014-f806-42d1-ab1c-ce3220ff5365');

INSERT INTO `db_okaybank`.`agency` (`id`, `agency`, `employee_id`) VALUES ('af62786b-0a05-441a-a736-e65a06299d5d', '4595783501', '47d16014-f806-42d1-ab1c-ce3220ff5365');
INSERT INTO `db_okaybank`.`agency` (`id`, `agency`, `employee_id`) VALUES ('73cf374f-0802-4238-8b08-2b0f62fee585', '7598723601', '47d16014-f806-42d1-ab1c-ce3220ff5365');

INSERT INTO `db_okaybank`.`account` (`id`, `account`, `balance`, `password`, `agency_id`, `customer_id`, `employee_id`) VALUES ('12883424-eace-4f0a-b8ef-b6aeb3cc0afe', '7280166801', '0.00', '2548', '73cf374f-0802-4238-8b08-2b0f62fee585', '87110d15-6340-4db1-8a14-63ea369a7df9', '47d16014-f806-42d1-ab1c-ce3220ff5365');
INSERT INTO `db_okaybank`.`account` (`id`, `account`, `balance`, `password`, `agency_id`, `customer_id`, `employee_id`) VALUES ('d4c0efa9-ea0f-4955-a846-8d28b81d86d9', '6663559501', '0.00', '4756', 'af62786b-0a05-441a-a736-e65a06299d5d', 'bc7b232c-b70f-4d3c-829a-2c47f22de952', '47d16014-f806-42d1-ab1c-ce3220ff5365');
```
## Clone repository
```bash
git clone https://github.com/abnerjosefelixbarbosa/okay-bank.git
```

# Autor

Abner José Felix Barbosa

Linkedin: https://www.linkedin.com/in/abner-jose-feliz-barbosa/
