import { Component } from '@angular/core';
import { ReviewService } from '../../services/review.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent {
  reviews:any[]=[];
  constructor(private reviewService:ReviewService){}

  ngOnInit(){
   
    this.getAllReviews();
  
  }
  getAllReviews(){
    this.reviewService.getAllReviews().subscribe((data)=>{this.reviews=data;
    //  console.log(this.reviews);
      this.reviews=this.reviews.filter((review)=>{
        return !review.approved;
      });
    
    });
  }
  approveReview(review:any){
        this.reviewService.approveReview(review.reviewId).subscribe(()=>console.log("sucess"));
         
        this.reviews=this.reviews.filter((rev)=>{
          return rev.reviewId!=review.reviewId
        })
  }
  rejectReview(review:any){
    this.reviewService.rejectReview(review.reviewId).subscribe(()=>console.log("sucess"));
         
    this.reviews=this.reviews.filter((rev)=>{
      return rev.reviewId!=review.revi
    })
  }

}
