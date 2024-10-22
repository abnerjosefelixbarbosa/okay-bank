import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class CustomerModule {
  private id: String;
  private name: String;
  private email: String;
  private password: String;
  private contact: String;
  private cpf: String;
  private rg: String;
  private birthDate: Date;
  private addressPostalCode: String;
  private addressNumber: String;
  private addressName: String;
  private addressDistrict: String;
  private addressState: String;
  private addressCity: String;

  constructor(id: String, name: String, email: String, password: String, contact: String, cpf: String) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.contact = contact;
    this.cpf = cpf;
  }

  public getId(): String  {
    return this.id;
  }
}
