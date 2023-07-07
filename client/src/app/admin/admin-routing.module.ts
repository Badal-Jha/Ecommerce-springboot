import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReviewsComponent } from './components/reviews/reviews.component';
import { authGuard } from './auth.guard';
import { AddProductComponent } from './components/add-product/add-product.component';

const routes: Routes = [
  {path:'reviews',component:ReviewsComponent,canActivate:[authGuard]},
  {path:'add',component:AddProductComponent,canActivate:[authGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
