import { CanActivateFn, Router } from '@angular/router';
import { Inject, inject } from '@angular/core';
export const authGuard: CanActivateFn = (route, state) => {
 
  const router=inject(Router);
  console.log("executing authguard",localStorage.getItem("loggedIn"));
  const userLoggedIn=localStorage.getItem("loggedIn");
  
  if(userLoggedIn==='true'){
    
    return true;
  }
 else {
 
  router.navigate(['/login'])
 
  return false;
 }

};
