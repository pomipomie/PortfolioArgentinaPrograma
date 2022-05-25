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

  loggedUser:boolean=false;  //debe ser false al inicio
  exps:Array<any> | undefined;
  exp:any;
  expts:Array<any> | undefined;
  expt:any;
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
        description:[''],
        id_expt:[[Validators.required]]
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
      this.exps=data;
    });
    this.datosPortfolio.obtenerDatosExpT().subscribe(data => {
      this.expts=data;
    });
  }

  onSave() {
    if (this.form.valid) {
      let d = this.form.value;
      this.datosPortfolio.obtenerExp(d.id_exp).subscribe(data => {
        this.exp = data;
        d.id = this.exp.id;
        this.datosPortfolio.obtenerExpT(d.id_expt).subscribe(
          dat => {
            d.id_expt = dat;
            d.place = this.exp.place;
            if (d.workplace == "") {
              d.workplace = this.exp.workplace;
            }
            if (d.startDate == "") {
              d.startDate = this.exp.startDate;
            }
            if (d.endDate == "") {
              d.endDate = this.exp.endDate;
            }
            if (d.description == "") {
              d.description = this.exp.description;
            }
            this.datosPortfolio.editExp(d).subscribe(
              d => {
                this.exp = d;
                window.location.reload();
              })
          })
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
