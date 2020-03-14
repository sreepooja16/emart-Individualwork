import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemListComponent } from './emart/item/item-list/item-list.component';
import { ItemDisplayComponent } from './emart/item/item-display/item-display.component';
import { CartListComponent } from './emart/cart/cart-list/cart-list.component';
import { BillViewComponent } from './emart/bill/bill-view/bill-view.component';
import { BillListComponent } from './emart/bill/bill-list/bill-list.component';
import { LoginComponent } from './emart/signup/login/login.component';

import { SellerSignupComponent } from './seller-signup/seller-signup.component';
import { BuyerSignupComponent } from './emart/signup/buyer-signup/buyer-signup.component';
import { 
  AuthGuardService as AuthGuard 
} from './auth-guard.service';




const routes: Routes = [{

  path: 'login',
  component: LoginComponent
},
{
  path: 'item-list',
  component: ItemListComponent
},
{
  path: 'item-display/:iId',
  component: ItemDisplayComponent
},
{
path:'seller-signup',
component:SellerSignupComponent
},
{
path:'buyer-signup',
component:BuyerSignupComponent
},
{
  path: 'cart-list',
  component: CartListComponent
},
{
  path: 'bill-view',
  component: BillViewComponent
},

{

  path: 'bill-list',
  component: BillListComponent
},
{ 
  path: 'item-list',
  component: ItemListComponent,
  canActivate:  [AuthGuard] 
},
{ path: '**', redirectTo: '/login' }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
