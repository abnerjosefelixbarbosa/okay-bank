export default class Position {
  private id: string;
  private position: string;
  private bonus: number;

  constructor(id: string, position: string, bonus: number) {
    this.id = id;
    this.position = position;
    this.bonus = bonus;
  }

  getPosition() {
    return {
      id: this.id,
      position: this.position,
      bonus: this.bonus,
    };
  }
}
