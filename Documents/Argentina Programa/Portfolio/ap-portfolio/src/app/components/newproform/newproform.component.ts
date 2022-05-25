import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-newproform',
  templateUrl: './newproform.component.html',
  styleUrls: ['./newproform.component.css']
})
export class NewproformComponent implements OnInit {

  loggedUser:boolean=false;  //debe ser false al inicio
  projs:Array<any> | undefined;
  proj:any;
  openModalN:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        pname: ['', [Validators.required]],
        pdescription: ['', [Validators.required]],
        purl: ['', [Validators.required]],
        ppreview: ['', [Validators.required]]
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
    if (this.form.valid) {
      let d = this.form.value;
      let thisId:Object;
      this.datosPortfolio.obtenerDatos().subscribe( data =>
        {thisId = data;
        d.id = thisId;
        this.datosPortfolio.newPro(d).subscribe(
          d => {
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
