import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ContatoComponent } from './pages/contato/contato.component';
import { ContaCorrenteComponent } from './pages/conta-corrente/conta-corrente.component';
import { ContaPoupancaComponent } from './pages/conta-poupanca/conta-poupanca.component';
import { ProduteAndServiceComponent } from './pages/produte-and-service/produte-and-service.component';

export const routes: Routes = [
    {
        path: "",
        component: HomeComponent
    },
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: "contato",
        component: ContatoComponent
    },
    {
        path: "conta-corrente",
        component: ContaCorrenteComponent
    },
    {
        path: "conta-poupanca",
        component: ContaPoupancaComponent
    },
    {
        path: "product-and-service",
        component: ProduteAndServiceComponent
    }
];
