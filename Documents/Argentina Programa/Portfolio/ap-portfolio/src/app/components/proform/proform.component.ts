import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-proform',
  templateUrl: './proform.component.html',
  styleUrls: ['./proform.component.css']
})
export class ProformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  projs:Array<any> | undefined;
  proj:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) {

    this.form = formBuilder.group(
      {
        id_projects: [[Validators.required]],
        pname: ['', [Validators.required]],
        pdescription: [''],
        purl: [''],
        ppreview: ['']
      }
    );
   }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosPro().subscribe(data => {
      this.projs=data;
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
      this.datosPortfolio.getPro(d.id_projects).subscribe(data =>{
        this.proj=data;
        d.id=this.proj.id;
        if (d.pname == (null || "")) {
          d.pname = this.proj.pname;
        }
        if (d.pdescription == (null || "")) {
          d.pdescription = this.proj.pdescription;
        }
        if (d.url == (null || "")) {
          d.url = this.proj.url;
        }
        if (d.ppreview == (null || "")) {
          d.ppreview = this.proj.ppreview;
        }
        this.datosPortfolio.editPro(d).subscribe(
          d => {
            console.log(d); //TEST - not working
            this.proj = d;
            window.location.reload();
          })
      })
    }
    else{
      alert("Formulario inválido");
    }
  }

}
