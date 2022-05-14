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

  loggedUser:boolean=true;  //debe ser false al inicio
  edus:Array<any> | undefined;
  edu:any;
  openModal:boolean=false;
  form:FormGroup;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) { 
    this.form = formBuilder.group(
      {
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

    this.datosPortfolio.newEdu(d).subscribe(
      d => {
        console.log(d); //TEST - not working
        this.edu = d;
        window.location.reload();
      })
      // console.log("hola"); //TEST
          }
    else{
      alert("Formulario inválido");
    }
  }

}
