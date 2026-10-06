CREATE TABLE IF NOT EXISTS agency_tb (
    id VARCHAR PRIMARY KEY,
    number VARCHAR(20) NOT NULL UNIQUE,
    creation_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_tb (
    id VARCHAR PRIMARY KEY,
    document VARCHAR(20) NOT NULL UNIQUE,
    birthDate DATE NOT NULL,
    name VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(30) NOT NULL UNIQUE,
    phone VARCHAR(30) NOT NULL UNIQUE,
    customer_type VARCHAR(2) NOT NULL,
    
    -- Address
    postal_code VARCHAR(10) NOT NULL,
    address_name VARCHAR(30) NOT NULL,
    address_number INTEGER NOT NULL,
    district VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_tb (
    id VARCHAR PRIMARY KEY,
    matriculation VARCHAR(10) NOT NULL UNIQUE,
    birth_Date DATE NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    salary NUMERIC(30,2) NOT NULL,
    
    -- Address
    postal_code VARCHAR(10) NOT NULL,
    address_name VARCHAR(30) NOT NULL,
    address_number INTEGER NOT NULL,
    district VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,

    email VARCHAR(30) NOT NULL UNIQUE,
    phone VARCHAR(30) NOT NULL UNIQUE,
    journey INTEGER NOT NULL,
    employee_type VARCHAR(20) NOT NULL,
    employee_status VARCHAR(20) NOT NULL,

    agency_id VARCHAR NOT NULL,
    
    FOREIGN KEY (agency_id) REFERENCES agency_tb(id)
);

CREATE TABLE IF NOT EXISTS account_tb (
    id VARCHAR PRIMARY KEY,
    number VARCHAR(20) NOT NULL UNIQUE,
    balance NUMERIC(30,2) NOT NULL,
    creation_date DATE NOT NULL,
    password VARCHAR NOT NULL UNIQUE,
    account_type VARCHAR(20) NOT NULL,

    customer_id VARCHAR NOT NULL,
    agency_id VARCHAR NOT NULL,

    FOREIGN KEY (customer_id) REFERENCES customer_tb(id),
    
    FOREIGN KEY (agency_id) REFERENCES agency_tb(id)
);

CREATE TABLE IF NOT EXISTS card_tb (
    id VARCHAR PRIMARY KEY,
    number VARCHAR(16) NOT NULL UNIQUE,
    holder VARCHAR(100) NOT NULL,
    validation_date DATE NOT NULL,
    flag VARCHAR(20) NOT NULL,
    cvv VARCHAR(3) NOT NULL UNIQUE,
    password VARCHAR NOT NULL UNIQUE,
    card_type VARCHAR(20) NOT NULL,
    "limit" NUMERIC(30,2) NOT NULL,

    agency VARCHAR(20) NOT NULL,
    account VARCHAR(20) NOT NULL,

    customer_id VARCHAR NOT NULL,

    FOREIGN KEY (customer_id) REFERENCES customer_tb(id)
);

CREATE TABLE IF NOT EXISTS transfer_tb (
    id VARCHAR PRIMARY KEY,

    -- Payer
    payer_name VARCHAR(100) NOT NULL,
    payer_document VARCHAR(20) NOT NULL,
    payer_institution VARCHAR(50) NOT NULL,
    payer_account_number VARCHAR(10) NOT NULL,
    payer_agency_number VARCHAR(15) NOT NULL,

    -- Receiver
    receiver_name VARCHAR(100) NOT NULL,
    receiver_document VARCHAR(20) NOT NULL,
    receiver_institution VARCHAR(50) NOT NULL,
    receiver_account_number VARCHAR(20) NOT NULL,
    receiver_agency_number VARCHAR(20) NOT NULL,

    "value" NUMERIC(30,2) NOT NULL,
    transfer_date_and_time TIMESTAMP NOT NULL,
    transfer_type VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_transfer_tb (
    id VARCHAR PRIMARY KEY,

    transfer_id VARCHAR NOT NULL UNIQUE,
    account_id VARCHAR NOT NULL UNIQUE,

    FOREIGN KEY (transfer_id) REFERENCES transfer_tb(id),

    FOREIGN KEY (account_id) REFERENCES account_tb(id)
);