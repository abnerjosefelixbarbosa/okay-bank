import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ContactComponent } from './pages/contact/contact.component';
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
        path: "contact",
        component: ContactComponent
    },
    {
        path: "product-and-service",
        component: ProduteAndServiceComponent
    }
];
