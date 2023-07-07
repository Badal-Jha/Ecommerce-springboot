import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  countUsers:Number=0;
  countProducts:Number=0;
  countReviews:Number=0;

  constructor(private router:Router,private productService:ProductsService){}
 navigateToProducts(){
    this.router.navigate(["/products"])
 }
 
 ngOnInit(){
  this.productService.getCounts().subscribe((data)=>{
    this.countProducts=data.countProducts;
    this.countReviews=data.countReviews;
    this.countUsers=data.countUsers;
    console.log(this.countProducts+"test");
  });
 }
 
}
