import { DataValidBalance } from "../types/DataValidBalance";

export async function validBalance(data: DataValidBalance) {
    if (data.balance === 0) {
        throw new Error("Balance is 0");
    }
    if (data.balance > data.currentBalance) {
        throw new Error("Balance is greater than current balance");
    }
}