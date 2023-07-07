import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
      
  products:any[]=[];
  searchCriteria={
    brand:'',
    productName:'',
    productCode:''

  }
  role:any=localStorage.getItem("loggedInUserRole");
  constructor(private productService:ProductsService,private router:Router){
   
  };


  ngOnInit(){
    console.log("called");
   
    this.productService.getProducts().subscribe((data)=>this.products=data);
   
  }
  openProductDetails(product:Product){
 
    this.router.navigateByUrl('/product-details', { state: { product } });
  }

  onSubmit(form:any){
  
   if(this.searchCriteria.brand=='' && this.searchCriteria.productCode=='' && this.searchCriteria.productName==''){
    alert("provide atleast one input to search!!");
   }
   else
    this.productService.searchProducts(this.searchCriteria).subscribe((data)=>this.products=data);
   
  }
 
}
