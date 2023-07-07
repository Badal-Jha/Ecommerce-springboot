import { Injectable } from '@angular/core';
import { Observable,of,catchError,throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Review } from '../Review';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private httpClient:HttpClient) { };
  url="http://localhost:8081";
  //get counts fields
  getCounts():Observable<any>{
      const _url=this.url+"/stats"
      return this.httpClient.get(_url);
  }

  //get all the products

  getProducts():Observable<any>{
    const _url=this.url+"/products"
      return this.httpClient.get(_url).pipe(catchError(this.handleError));
  }

  //search product using params

  searchProducts(searchCriteria:any):Observable<any>{
    const _url=this.url+"/products/search";
    let params = new HttpParams();

  // Add parameters to the HttpParams object
  //0 '' false
  if(searchCriteria.productCode)
  params = params.append('productCode', searchCriteria.productCode);
  if(searchCriteria.brand)
  params = params.append('productBrand', searchCriteria.brand);
  if(searchCriteria.productName)
  params=params.append('productName',searchCriteria.productName);

  return this.httpClient.get(_url,{params}).pipe(catchError(this.handleError));

  }
  
//post a review

addReview(review:Review,productCode:string):Observable<any>{
  

  const _url=this.url+`/reviews/${productCode}`;

  return this.httpClient.post(_url,review).pipe(catchError(this.handleError));
}




  //handle error
   handleError(error:HttpErrorResponse){
    return  throwError(error);
   }
}
