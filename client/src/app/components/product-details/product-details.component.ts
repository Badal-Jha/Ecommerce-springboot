import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Review } from 'src/app/Review';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {

  product:any;
  review:string='';
  rating:Number=0;
  reviewSubmitted = false;
  //we will replace it with logged in user 
  username:any=localStorage.getItem('loggedInUser');
  selectedRating: string = '';
  constructor(private productService:ProductsService){
};

  ngOnInit(){
    //console.log(history.state);
    console.log("refrshed");
    this.product=history.state.product;
    console.log(this.product);

  }
  
  onSubmitReview(form:any){
    //we can write some logic here if we want a user to review only once
   
    // if(!this.username){
    //        alert("You need to log in to review a product");
    //        return;
    // }

    //get current date
    const currentDate = new Date();

    const day = currentDate.getDate().toString().padStart(2, '0');
    const month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
    const year = currentDate.getFullYear().toString();
    const formattedDate = `${day}/${month}/${year}`;
   

     // //post review
    const rev:Review={
      review:this.review,
      date:formattedDate,
      username:this.username,
      rating:this.rating,
     }

   console.log(this.product.productCode);

   this.productService.addReview(rev,this.product.productCode).subscribe((data)=>{
    
    form.reset();
   });
   
   alert("review submitted wait for admin to approve the review!!");

  }
}
