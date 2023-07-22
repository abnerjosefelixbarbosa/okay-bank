export class CPFFormLoginError extends Error {
    constructor(message: string) {
        super()
        this.message = message
    }
}