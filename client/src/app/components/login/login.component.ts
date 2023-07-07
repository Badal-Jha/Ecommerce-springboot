import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 username:string='';
 password:string=''

 constructor(private userService:UserService,private router:Router){};


 loginFormSubmit(loginForm:any){
    this.userService.login(this.username,this.password).subscribe((data:any)=>{
      if(data){
        localStorage.setItem("loggedIn","true");
        localStorage.setItem("loggedInUser",data.username);
        localStorage.setItem("loggedInUserRole",data.roles);
        loginForm.reset();
       
   this.router.navigate(["/products"]);
  
      }
    })
   

 }
}
