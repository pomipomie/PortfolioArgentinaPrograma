import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-newskiform',
  templateUrl: './newskiform.component.html',
  styleUrls: ['./newskiform.component.css']
})
export class NewskiformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  skills:Array<any> | undefined;
  skill:any;
  openModalN:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        skillname: ['', [Validators.required]],
        skillvalue: ['', [Validators.required]]
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosSki().subscribe(data => {
      this.skills=data;
      //console.log(this.skills);  // FOR TESTING
    });
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

    this.datosPortfolio.newSkill(d).subscribe(
      d => {
        console.log(d); //TEST - not working
        this.skills = d;
        window.location.reload();
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
