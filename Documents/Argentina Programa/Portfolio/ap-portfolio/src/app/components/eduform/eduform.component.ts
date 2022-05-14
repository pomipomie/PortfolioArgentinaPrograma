import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-eduform',
  templateUrl: './eduform.component.html',
  styleUrls: ['./eduform.component.css']
})
export class EduformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  edus:Array<any> | undefined;
  edu:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 

    this.form = formBuilder.group(
      {
        id_educ: [[Validators.required]],
        title: ['', [Validators.required]],
        institution: ['', [Validators.required]],
        place:[''],
        certif: [''],
        startDate:[''],
        endDate:[''],
        educInfo:['']
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosEdu().subscribe(data => {
      //console.log(data);  // FOR TESTING
      this.edus=data;
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

    this.datosPortfolio.editEdu(d).subscribe(
      d => {
        console.log(d); //TEST - not working
        console.log(d.id_edu); //TEST - NOT WORKING
        if (d.place == null) {
          d.place = this.edu.place;
        }
        if (d.startDate == null) {
          d.startDate = this.edu.startDate;
        }
        if (d.endDate == null) {
          d.endDate = this.edu.endDate;
        }
        if (d.educInfo == null) {
          d.educInfo = this.edu.educInfo;
        }
        if (d.certif == null) {
          d.certif = this.edu.certif;
        }
        this.edu = d;
        window.location.reload();
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
