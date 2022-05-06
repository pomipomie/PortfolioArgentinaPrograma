import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AutenticationService } from 'src/app/services/autentication.service';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {

  logOk:boolean=false;
  loginError:string=" ";

  form:FormGroup;
  constructor(private formBuilder:FormBuilder, private autenticationService:AutenticationService, private route:Router) { 
    this.form = formBuilder.group(
      {
        email:['',[Validators.required,Validators.email]],
        password:['',[Validators.required,Validators.minLength(8)]]
        /*,
        deviceId:[""],
        deviceType:[""],
        notificationToken:[""]*/
      }
    );
  }

  ngOnInit(): void {
  }

  get Email() {
    return this.form.get('email');
  }

  get Password() {
    return this.form.get('password');
  }

  onSend(event:Event) {
    event.preventDefault;
    this.autenticationService.logIn(this.form.value).subscribe(data=>{
      console.log("DATA: "+JSON.stringify(data)); // para pruebas en consola
      if(data==null) {
        this.loginError="Email o contraseña inválidos";
      } else {
        this.autenticationService.setToken(data.id);
        console.log("Token: "+data.id); // para pruebas
        this.logOk=true;
        window.location.reload();
        //this.route.navigate(['/app']);
      }
    })
  }
}
