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

  form:FormGroup;
  constructor(private formBuilder:FormBuilder, private autenticationService:AutenticationService, private route:Router) { 
    this.form = formBuilder.group(
      {
        username:['',[Validators.required,Validators.email]],
        password:['',[Validators.required,Validators.minLength(8)]],
        deviceId:[""],
        deviceType:[""],
        notificationToken:[""]
      }
    );
  }

  ngOnInit(): void {
  }

  get Username() {
    return this.form.get('username');
  }

  get Password() {
    return this.form.get('password');
  }

  onSend(event:Event) {
    event.preventDefault;
    this.autenticationService.LogIn(this.form.value).subscribe(data=>{
      console.log("DATA: "+JSON.stringify(data)); // para pruebas en consola
      this.route.navigate(['']) // '/portfolio'
    })
  }
}
