import Employee from "./Employee";

export default interface Customer {
    id?: string;
    cpf?: string;
    rg?: string;
    email?: string;
    password?: string;
    telephone?: string;
    birthDate?: Date;
    name?: string;
    addressNumber?: number;
    addressZipCode?: string;
    address?: string;
    addressDistrict?: string;
    addressCity?: string;
    addressState?: string;
    employee?: Employee;
}