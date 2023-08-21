const BASE_URL = import.meta.env.BACKEND_URL ?? "http://localhost:8080";

export const CUSTOMERS_LOGIN_BY_CPF_AND_PASSWORD = `${BASE_URL}/customers/login-by-cpf-and-password`;
export const ACCOUNTS_TRANSFER_BALANCE = `${BASE_URL}/accounts/transfer-balance`;
export const ACCOUNTS_FIND_BY_AGENCY_AND_ACCOUNT = `${BASE_URL}/accounts/find-by-agency-and-account`;
export const ACCOUNTS_GET_BY_ID = `${BASE_URL}/accounts/get-by-id`;
export const ACCOUNTS_GET_ALL_BY_CUSTOMER_ID = `${BASE_URL}/accounts/get-all-by-customer-id`;