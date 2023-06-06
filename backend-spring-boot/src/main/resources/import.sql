create database if not exists db_okaybank character set UTF8mb4 collate utf8mb4_bin;

INSERT INTO db_okaybank.customer (id, name) VALUES (uuid(), 'customer');