import Position from "./Position";

export default interface Employee {
    id?: string;
    matriculation?: number;
    name?: string;
    salary?: number;
    position?: Position;
}