import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
 username:string='';
 password:string='';
 confirmPassword:string='';
 msg:string='';
 constructor(private userService:UserService){};
 onRegister(registerForm:any){
  if(this.password!==this.confirmPassword){
    alert("password and confirm password not matching");
    return;
  }
  const user={
    username:this.username,
    password:this.password
  }
  
 this.userService.register(user).subscribe((data)=>{console.log("data"+data)}
   ,error=>alert(error.error.text)
 
 );
 registerForm.reset();
 }
}
