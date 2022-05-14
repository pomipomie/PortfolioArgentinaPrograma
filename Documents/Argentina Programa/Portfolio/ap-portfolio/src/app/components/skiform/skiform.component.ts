import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-skiform',
  templateUrl: './skiform.component.html',
  styleUrls: ['./skiform.component.css']
})
export class SkiformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  skills:Array<any> | undefined;
  skill:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        id_skills: [[Validators.required]],
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

    this.datosPortfolio.editSkill(d).subscribe(
      d => {
        console.log(d); //TEST - not working
        console.log(d.id_skills); //TEST - NOT WORKING
        this.skills = d;
        window.location.reload();
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
