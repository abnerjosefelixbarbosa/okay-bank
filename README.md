# okay-bank

# LICENSE
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/abnerjosefelixbarbosa/okay-bank/blob/main/LICENSE)

# Sobre

O okay bank é uma instituição bancaria que atua fora do Brasil e deseja atuar dentro do pais para alcançar novos públicos, no momento a instituição atende, em média, mais de 5.000.000 de clientes. Para isso a equipe junto com o gerente de TI reuniram-se para propor um banco digital que inicialmente entrará em operação na aplicação web no qual realizará serviços bancários. Um cliente possui no mínimo um e no máximo várias contas. Uma conta é possuída no mínimo um e no máximo um cliente. Uma conta possui no mínimo uma e no máximo uma agência. Uma agência possui no mínimo nenhuma e no máximo várias contas. Um funcionário registra no mínimo nenhuma e no máximo várias agências. Uma agência é registrada no mínimo um e no máximo um funcionário. Um funcionário registra no mínimo nenhum e no máximo várias contas. Uma conta é registrada no mínimo um e no máximo um funcionário. Um funcionário registra no mínimo nenhum e no máximo vários clientes. Um cliente é registrado no mínimo um e no máximo um funcionário, sendo funcionário normalmente bancário. Um funcionário possui no mínimo um e no máximo um cargo. Um cargo é possuído no mínimo um e no máximo vários funcionários.    

Os dados do cliente são id, cpf, rg, e-mail, senha, telefone, data de nascimento, nome e endereço (número, cep, endereço, bairro, cidade, estado).  Os dados da conta são id, conta, senha e saldo. Os dados da agência são id e agência. Os dados do funcionário são id, matrícula, nome e salário. Os dados do cargo são id, cargo e bonificação.  

## Modelagem

![imagem1](https://github.com/abnerjosefelixbarbosa/assents/blob/main/okay_bank/modelo_okay_bank.jpg)

# Features

- Save position

## Back end
- Java 17
- Spring boot
- JPA hibernate
- Maven
- MySQL
- Validation
- Lombok
- Junit
- Swagger

# Execução do Projeto
Pré-requisito: Java 17

```JSON
# position data
{
  "position": "administrative manager",
  "bonus": 0.20
}

{
  "position": "administrative agent",
  "bonus": null
}
```

```bash
# clonar repositório
git clone https://github.com/abnerjosefelixbarbosa/okay-bank.git
```

# Autor

Abner José Felix Barbosa

Linkedin: https://www.linkedin.com/in/abner-jose-feliz-barbosa/
