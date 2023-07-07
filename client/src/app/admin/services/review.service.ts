import { Injectable } from '@angular/core';
import { Observable,of,catchError,throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private httpClient:HttpClient) { 
 }

 url="http://localhost:8081/admin"
 //get all reviews

 getAllReviews():Observable<any>{
  const _url=this.url+"/reviews"
  return this.httpClient.get(_url);
 }

 //approve

 approveReview(reviewId:Number):Observable<any>{
  const _url=this.url+`/reviews/${reviewId}`
  return this.httpClient.patch(_url,{});
 }

 //reject review
 rejectReview(reviewId:Number):Observable<any>{
  const _url=this.url+`/reviews/${reviewId}`
  return this.httpClient.delete(_url);
 }

 //add product

 addProduct(product:any){
    const _url="http://localhost:8081/products";
     return this.httpClient.post(_url,product);
 }

}
