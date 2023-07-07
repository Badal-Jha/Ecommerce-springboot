import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
   loggedIn:any=''
   username:any=''

  constructor(private router:Router){};

   ngOnInit(){
    this.loggedIn=localStorage.getItem("loggedIn");
    this.username=localStorage.getItem("loggedInUser");
   }
   logout(){
    localStorage.removeItem("loggedIn");
    localStorage.removeItem("loggedInUser");
    localStorage.removeItem("loggedInUserRole");
    location.reload();
    this.router.navigate(["/login"]);
   }
}
