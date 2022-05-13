import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validator, Validators } from '@angular/forms';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { AutenticationService } from 'src/app/services/autentication.service';

@Component({
  selector: 'app-newexpform',
  templateUrl: './newexpform.component.html',
  styleUrls: ['./newexpform.component.css']
})
export class NewexpformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  openModalN:boolean=false;
  form:FormGroup;
  exp:any;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        job: ['', [Validators.required]],
        workplace:['', [Validators.required]],
        startDate:[''],
        endDate:[''],
        description:['']
      }
    );
   }

  ngOnInit(): void {
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
  }

  onSave() {
    alert(JSON.stringify(this.form.value)); //para pruebas
    if (this.form.valid) {
      let d = this.form.value;
      console.log(d); //TEST

    this.datosPortfolio.newExp(d).subscribe(
      d => {
        console.log(d); //TEST - not working
        this.exp = d;
        window.location.reload();
      })
      // console.log("hola"); //TEST
          }
    else{
      alert("Formulario inválido");
    }
  }

}
