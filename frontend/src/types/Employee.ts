import { Position } from "./Position";

export interface Employee {
  id: string;
  matriculation: number;
  name: string;
  salary: number;
  position: Position;
}
