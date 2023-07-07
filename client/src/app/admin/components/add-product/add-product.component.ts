import { Component } from '@angular/core';
import { Product } from 'src/app/Product';
import { ReviewService } from '../../services/review.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {

   product:any={
    productCode:'',
    productName:'',
    productBrand:'',
    price:0,
    imgUrl:'',
    productDesc:'',
  }
 constructor(private reviewService:ReviewService){
 }
  onSubmit(productForm:any){
    console.log(this.product);

    this.reviewService.addProduct(this.product).subscribe((data)=>{
      console.log(data);
      alert("product addedd");
     productForm.reset();
    },
    (error)=>console.log(error));
  }
}
