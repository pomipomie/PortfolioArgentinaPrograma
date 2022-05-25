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

  loggedUser:boolean=false;  //debe ser false al inicio
  edus:Array<any> | undefined;
  edu:any;
  educts:Array<any> | undefined;
  educt:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 

    this.form = formBuilder.group(
      {
        id_educ: [[Validators.required]],
        title: ['', [Validators.required]],
        institution: [''],
        place:[''],
        educUrl: [''],
        certif: [''],
        startDate:[''],
        endDate:[''],
        educInfo:[''],
        id_educt: [[Validators.required]]
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosEdu().subscribe(data => {
      this.edus=data;
    });
    this.datosPortfolio.obtenerDatosEduT().subscribe(data => {
      this.educts=data;
    })
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
  }

  onSave() {
    if (this.form.valid) {
      let d = this.form.value;
      this.datosPortfolio.obtenerEdu(d.id_educ).subscribe(data => {
        this.edu=data;
        d.id=this.edu.id;
        d.educfields=this.edu.educfields;
        this.datosPortfolio.obtenerEducT(d.id_educt).subscribe(dat=>{
          d.id_educt=dat;
          if (d.place == (null || "")) {
            d.place = this.edu.place;
          }
          if (d.institution == (null || "")) {
            d.institution = this.edu.institution;
          }
          if (d.startDate == (null || "")) {
            d.startDate = this.edu.startDate;
          }
          if (d.endDate == (null || "")) {
            d.endDate = this.edu.endDate;
          }
          if (d.educInfo == (null || "")) {
            d.educInfo = this.edu.educInfo;
          }
          if (d.educUrl == (null || "")) {
            d.educUrl = this.edu.educUrl;
          }
          if (d.certif == (null || "")) {
            d.certif = this.edu.certif;
          }
          this.datosPortfolio.editEdu(d).subscribe(
            d => {
              this.edu = d;
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
