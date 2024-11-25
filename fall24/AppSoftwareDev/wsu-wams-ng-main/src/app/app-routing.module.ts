import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {CustomersComponent} from "./pages/customers/customers.component";
import {TechniciansComponent} from "./pages/technicians/technicians.component";
import {OrdersComponent} from "./pages/orders/orders.component";
import {NotFoundComponent} from "./pages/not-found/not-found.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'customers', component: CustomersComponent },
  { path: 'technicians', component: TechniciansComponent },
  { path: 'orders', component: OrdersComponent },
  // Wildcard route for a 404 page
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
