export class CPFFormLoginError extends Error {
    constructor(message: string) {
        super()
        this.message = message
    }
}

export class FormLoginError extends Error {
    constructor(message: string) {
        super()
        this.message = message
    }
}