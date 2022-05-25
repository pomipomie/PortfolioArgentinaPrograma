import { Component, OnInit } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  loggedUser:boolean=false;  //debe ser false al inicio
  myPortfolio:any;
  user:any;
  url = "/portfolioap/user";
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) {
  this.form = formBuilder.group(
      {
        gitHub: ['', [Validators.required]],
        facebook:['', [Validators.required]],
        twitter:['', [Validators.required]],
        instagram: ['', [Validators.required]],
        phone:['', [Validators.required]],
        linkedIn:['', [Validators.required]],
        codePen: ['', [Validators.required]]
      }
    );
  }

  ngOnInit(): void {
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
    this.datosPortfolio.obtenerDatos().subscribe(data => {
        this.myPortfolio=data;
    });
  }

  onSave() {
    if (this.form.valid) {
      let d = this.form.value;
      d.aboutText = this.myPortfolio.aboutText;
      d.birthDate = this.myPortfolio.birthDate;
      d.location = this.myPortfolio.location;
      d.firstName = this.myPortfolio.firstName;
      d.lastName = this.myPortfolio.lastName;
      d.picUrl = this.myPortfolio.picUrl;
      d.email = this.myPortfolio.email;
      d.password = this.myPortfolio.password;
      d.id = this.autenticationService.getUserLogged();
  
    this.datosPortfolio.editUser(d).subscribe(
      d => {
        this.user = d;
        window.location.reload();
      })
          }
    else{
      alert("Formulario inválido");
    }
  }
}
