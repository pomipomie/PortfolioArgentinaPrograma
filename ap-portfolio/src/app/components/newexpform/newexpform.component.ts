import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validator, Validators } from '@angular/forms';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { AutenticationService } from 'src/app/services/autentication.service';

@Component({
  selector: 'app-newexpform',
  templateUrl: './newexpform.component.html',
  styleUrls: ['./newexpform.component.css']
})
export class NewexpformComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  openModalN:boolean=false;
  form:FormGroup;
  exp:any;
  expts:Array<any> | undefined;
  expt:any;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        job: ['', [Validators.required]],
        workplace:['', [Validators.required]],
        startDate:[''],
        endDate:[''],
        description:[''],
        id_expt:['', [Validators.required]]
      }
    );
   }

  ngOnInit(): void {
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
     this.datosPortfolio.obtenerDatosExpT().subscribe(data => {
      //console.log(data);  // FOR TESTING
      this.expts=data;
    });
  }

  onSave() {
    alert(JSON.stringify(this.form.value)); //para pruebas 
    if (this.form.valid) {
      let d = this.form.value;
      let thisId:Object;
      this.datosPortfolio.obtenerDatos().subscribe( data =>
        {thisId = data;
        //console.log("id: "+JSON.stringify(thisId));//test
        d.id = thisId;
        //console.log("realid: "+JSON.stringify(d.id));//test
        this.datosPortfolio.obtenerExpT(d.id_expt).subscribe(
          dat => {
            d.id_expt = dat;
          //  console.log(dat);
          d.place = "";
          console.log(d); //TEST
          this.datosPortfolio.newExp(d).subscribe(
            d => {
              console.log(d); //TEST - working
              this.exp = d;
              window.location.reload();
            })
          }
        )
      })
          }
    else{
      alert("Formulario inválido");
    }
  }

}
