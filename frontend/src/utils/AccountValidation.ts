import { AccountService } from "../services/AccountService";
import { Account, AccountInterface } from "../types/Account";

export class AccountValidation implements AccountInterface {
    private accountInterface!: AccountInterface;

    setAccountInterface(accountInterface: AccountInterface) {
        this.accountInterface = accountInterface;
    }

    async validBalance(balance: number, currentBalance: number) {
        if (balance === 0) {
            throw new Error("Balance is 0");
        }
        if (balance > currentBalance) {
            throw new Error("Balance is greater than current balance");
        }
    }

    async getAllByCustomerId(id: string) {
        this.setAccountInterface(new AccountService());
        const request = await this.accountInterface?.getAllByCustomerId(id);
        return request
    }

    async findByAgencyAndAccount(data: Account) {
        this.setAccountInterface(new AccountService());
        const request = await this.accountInterface.findByAgencyAndAccount(data);
        
        if (request.id === data.id) {
            throw new Error("Account logged in")
        }

        return request
    }

    async getById(id: string) {
        this.setAccountInterface(new AccountService());
        const request = await this.accountInterface.getById(id);
        return request
    }

    async transferBalance(id1: string, id2: string, balance: number, password: string, currentPassword: string) {
        this.setAccountInterface(new AccountService());
        const request = await this.accountInterface.transferBalance(id1, id2, balance, password, currentPassword);

        return request
    }
}