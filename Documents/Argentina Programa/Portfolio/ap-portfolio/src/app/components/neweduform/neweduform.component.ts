import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';


@Component({
  selector: 'app-neweduform',
  templateUrl: './neweduform.component.html',
  styleUrls: ['./neweduform.component.css']
})
export class NeweduformComponent implements OnInit {

  loggedUser:boolean=true;
  edus:Array<any> | undefined;
  edu:any;
  educts:Array<any> | undefined;
  educt:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
        title: ['', [Validators.required]],
        institution: ['', [Validators.required]],
        place:[''],
        educUrl:[''],
        certif: [''],
        startDate:[''],
        endDate:[''],
        educInfo:[''],
        id_educt: ['', [Validators.required]]
      }
    );
  }


  ngOnInit(): void {
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
    this.datosPortfolio.obtenerDatosEduT().subscribe(data => {
      this.educts=data;
    })
  }

  onSave() {
    alert(JSON.stringify(this.form.value)); //para pruebas
    if (this.form.valid) {
      let d = this.form.value;
      console.log(d); //TEST
      let thisId:Object;
      this.datosPortfolio.obtenerDatos().subscribe( data =>
        {thisId = data;
        d.id = thisId;
        d.educfields=[];
        //console.log("realid: "+JSON.stringify(d.id));//test
        this.datosPortfolio.obtenerEducT(d.id_educt).subscribe(
          dat => {
            d.id_educt = dat;
          console.log(d); //TEST
          this.datosPortfolio.newEdu(d).subscribe(
            d => {
              console.log(d); //TEST - working
              this.edu = d;
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
