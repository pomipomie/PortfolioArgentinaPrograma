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
  skillts:Array<any> | undefined;
  skillt:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        id_skills: [[Validators.required]],
        skillname: [''],
        skillvalue: ['']
      }
    );
   }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosSki().subscribe(data => {
      this.skills=data;
      //console.log(this.skills);  // FOR TESTING
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
    alert(JSON.stringify(this.form.value)); //para pruebas
    if (this.form.valid) {
      let d = this.form.value;
      this.datosPortfolio.obtenerSkill(d.id_skills).subscribe(data =>{
        this.skill=data;
        d.id=this.skill.id;
        d.skillfields=this.skill.skillfields;
        d.id_skillt=this.skill.id_skillt;
        //this.datosPortfolio.obtenerSkillT(d.id_skillt).subscribe(dat =>{
        //  d.id_skillt=dat;
          if (d.skillname == (null || "")) {
            d.skillname=this.skill.skillname;
          }
          if (d.skillvalue == (null || "")) {
            d.skillvalue=this.skill.skillvalue;
          }
          this.datosPortfolio.editSkill(d).subscribe(
            d => {
              this.skill = d;
              window.location.reload();
            })
      //  })
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
