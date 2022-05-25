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

  loggedUser:boolean=false;  //debe ser false al inicio
  skills:Array<any> | undefined;
  skill:any;
  skillts:Array<any> | undefined;
  skillt:any;
  openModalN:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        skillname: ['', [Validators.required]],
        skillvalue: ['', [Validators.required]],
        id_skillt: ['', [Validators.required]]
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosSki().subscribe(data => {
      this.skills=data;
    });
    this.datosPortfolio.obtenerDatosSkillT().subscribe(data => {
      this.skillts=data;
    });
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
     console.log("100%(expert)=629; 90%(advanced)=560; 75%(upper-intermediate)=470; 50%(intermediate)=315; 25%(basic)=160; 5%(newbie)=50");
  }

  onSave() {
    if (this.form.valid) {
      let d = this.form.value;
      let thisId:Object;
      this.datosPortfolio.obtenerDatos().subscribe( data =>
        {thisId = data;
        d.id = thisId;
        d.skillfields=[];
        this.datosPortfolio.obtenerSkillT(d.id_skillt).subscribe(dat=>{
          d.id_skillt=dat;
          this.datosPortfolio.newSkill(d).subscribe(
            d => {
              this.skill = d;
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
