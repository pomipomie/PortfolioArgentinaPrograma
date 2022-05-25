import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { AutenticationService } from 'src/app/services/autentication.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  loggedUser:boolean=false;  //debe ser false al inicio
  myPortfolio:any;
  user:any;
  bDay:any;
  bMonth:any;
  bYear:any;
  url = "/portfolioap/user";
  
  form1: FormGroup;
  form2: FormGroup;
  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) {
    this.form1 = formBuilder.group(
      {
        picUrl: ['', [Validators.required]],
        firstName:['', [Validators.required]],
        lastName:['', [Validators.required]]
      }
    );
    this.form2 = formBuilder.group(
      {
        aboutText: ['', [Validators.required]],
        birthDate: ['']
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data => {
      this.myPortfolio=data;
      this.bDay = this.myPortfolio.birthDate[8]+this.myPortfolio.birthDate[9];
      switch(this.myPortfolio.birthDate[5]+this.myPortfolio.birthDate[6]) {
        case '01':
          this.bMonth = 'enero';
          break;
        case '02':
          this.bMonth = 'febrero';
          break;
        case '03':
          this.bMonth = 'marzo';
          break;
        case '04':
          this.bMonth = 'abril';
          break;
        case '05':
          this.bMonth = 'mayo';
          break;
        case '06':
          this.bMonth = 'junio';
          break;
        case '07':
          this.bMonth = 'julio';
          break;
        case '08':
          this.bMonth = 'agosto';
          break;
        case '09':
          this.bMonth = 'septiembre';
          break;
        case '10':
          this.bMonth = 'octubre';
          break;
        case '11':
          this.bMonth = 'noviembre';
          break;
        case '12':
          this.bMonth = 'diciembre';
          break;
      }
      this.bYear = this.myPortfolio.birthDate[0]+this.myPortfolio.birthDate[1]+this.myPortfolio.birthDate[2]+this.myPortfolio.birthDate[3];
    });
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
    } else {
      this.loggedUser=false;
    }
  }

  onSave() {
    if (this.form1.valid) {
      let d = this.form1.value;
      d.aboutText = this.myPortfolio.aboutText;
      d.birthDate = this.myPortfolio.birthDate;
      d.location = this.myPortfolio.location;
      d.phone = this.myPortfolio.phone;
      d.email = this.myPortfolio.email;
      d.password = this.myPortfolio.password;
      d.gitHub = this.myPortfolio.gitHub;
      d.twitter = this.myPortfolio.twitter;
      d.facebook = this.myPortfolio.facebook;
      d.instagram = this.myPortfolio.instagram;
      d.codePen = this.myPortfolio.codePen;
      d.linkedIn = this.myPortfolio.linkedIn;
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

  onSaveInfo() {
    if (this.form2.valid) {
      let d = this.form2.value;
      d.picUrl = this.myPortfolio.picUrl;
      d.firstName = this.myPortfolio.firstName;
      d.lastName = this.myPortfolio.lastName;
      d.location = this.myPortfolio.location;
      d.phone = this.myPortfolio.phone;
      d.email = this.myPortfolio.email;
      d.password = this.myPortfolio.password;
      d.gitHub = this.myPortfolio.gitHub;
      d.twitter = this.myPortfolio.twitter;
      d.facebook = this.myPortfolio.facebook;
      d.instagram = this.myPortfolio.instagram;
      d.codePen = this.myPortfolio.codePen;
      d.linkedIn = this.myPortfolio.linkedIn;
      if ( d.birthDate == "") {
        d.birthDate = this.myPortfolio.birthDate;
      }
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

