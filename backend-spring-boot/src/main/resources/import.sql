create database if not exists db_bancookay character set UTF8mb4 collate utf8mb4_bin;

insert into db_bancookay.customer (id, birth_date, cpf, email, name, password, rg) values (1, '1991-01-16', '949.612.154-30', 'cliente1@gmail.com', 'Alberto Camara', '481228', '36.825.176');
insert into db_bancookay.customer (id, birth_date, cpf, email, name, password, rg) values (2, '2005-01-17', '370.897.974-57', 'cliente2@gmail.com', 'Barbara Cardoso', '583245', '29.254.761');

insert into db_bancookay.address (id, address, city, neighborhood, number, state, zip_code, customer_id) values (1, 'Rua Barão de Pajeú', 'Recife', 'Dois Unidos', 671, 'PE', '52140-090', 1);
insert into db_bancookay.address (id, address, city, neighborhood, number, state, zip_code, customer_id) values (2, 'Travessa da Capela', 'Recife', 'Curado', 998, 'PE', '50790-061', 2);

insert into db_bancookay.account (id, account, agency, balance, password, customer_id) values (1, '13681-1', '1568-1', 1000, '4812', 1);
insert into db_bancookay.account (id, account, agency, balance, password, customer_id) values (2, '21224-1', '2210-1', 400, '5832', 2);

insert into db_bancookay.telephone (id, telephone, customer_id) values (1, '(81) 99709-5814', 1);
insert into db_bancookay.telephone (id, telephone, customer_id) values (2, '(81) 98458-3399', 2);

