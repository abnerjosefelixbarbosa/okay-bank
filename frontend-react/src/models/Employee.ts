import Position from "./Position";

export default class Employee {
    private id: string;
    private matriculation: number;
    private name: string;
    private salary: number;
    private position: Position;

    constructor(id: string, matriculation: number, name: string, salary: number, position: Position) {
        this.id = id;
        this.matriculation = matriculation;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    getEmployee() {
        return {
            id: this.id,
            matriculation: this.matriculation,
            name: this.name,
            salary: this.salary,
            position: this.position,
        }
    }
}