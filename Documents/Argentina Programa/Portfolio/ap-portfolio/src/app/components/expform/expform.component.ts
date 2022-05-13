import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validator, Validators } from '@angular/forms';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { AutenticationService } from 'src/app/services/autentication.service';

@Component({
  selector: 'app-expform',
  templateUrl: './expform.component.html',
  styleUrls: ['./expform.component.css']
})
export class ExpformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  exps:Array<any> | undefined;
  exp:any;
  expts:Array<any> | undefined;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    
    this.form = formBuilder.group(
      {
        id_exp: [[Validators.required]],
        job: ['', [Validators.required]],
        workplace:[''],
        startDate:[''],
        endDate:[''],
        description:['']
        // ,
        // expt:['', [Validators.required]]
      }
    );
  }

  ngOnInit(): void {
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
     this.datosPortfolio.obtenerDatosExp().subscribe(data => {
      //console.log(data);  // FOR TESTING
      this.exps=data;
    });
  }

  onSave() {
    alert(JSON.stringify(this.form.value)); //para pruebas
    if (this.form.valid) {
      let d = this.form.value;
      console.log(d); //TEST

    this.datosPortfolio.editExp(d).subscribe(
      d => {
        console.log(d); //TEST - not working
        console.log(d.id_exp); //TEST - NOT WORKING
        if (d.workplace == null) {
          d.workplace = this.exp.workplace;
        }
        if (d.startDate == null) {
          d.startDate = this.exp.startDate;
        }
        if (d.endDate == null) {
          d.endDate = this.exp.endDate;
        }
        if (d.description == null) {
          d.description = this.exp.description;
        }
        this.exp = d;
        window.location.reload();
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
