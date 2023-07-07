import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,of,catchError,throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  url="http://localhost:8081";
  constructor(private httpClient:HttpClient) { };

  register(user:any){
    const _url=this.url+"/user/register";
   return this.httpClient.post(_url,user).pipe(catchError(this.handleError));;
  }

  login(username:string,password:string):Observable<any>{
    const _url=this.url+"/user/login";
     const user={
      username:username,
      password:password
     }
    
      return this.httpClient.post(_url,user).pipe(catchError(this.handleError));
     
   
  }

  //isLogged In
   
 //handle error
 handleError(error:HttpErrorResponse){
  return  throwError(error);
 }
}
