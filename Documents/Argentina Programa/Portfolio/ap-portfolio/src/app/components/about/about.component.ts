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
  url = "/portfolioap/user";
  
  form1: FormGroup;
  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) {
    this.form1 = formBuilder.group(
      {
        picUrl: ['', [Validators.required]],
        firstName:['', [Validators.required]],
        lastName:['', [Validators.required]]
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data => {
    //  console.log(data);  // FOR TESTING
      this.myPortfolio=data;
    });
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
    } else {
      this.loggedUser=false;
    }
  }

  onSave() {
    //alert(JSON.stringify(this.form1.value)); //para pruebas
    if (this.form1.valid) {
      let d = this.form1.value;
      console.log(d.firstName);
      d.aboutText = this.myPortfolio.aboutText;
      d.birthDate = this.myPortfolio.birthDate;
      d.location = this.myPortfolio.location;
      d.phone = this.myPortfolio.phone;
      d.email = this.myPortfolio.email;
      d.password = this.myPortfolio.password;
      d.id = this.autenticationService.getUserLogged();
      //console.log(d); //TEST

    this.datosPortfolio.editUser(d).subscribe(
      d => {
        this.user = d;
      })
          }
    else{
      alert("Formulario inválido");
    }
  }
}

