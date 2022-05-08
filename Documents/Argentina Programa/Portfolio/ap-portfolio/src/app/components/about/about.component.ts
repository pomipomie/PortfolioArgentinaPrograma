import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { AutenticationService } from 'src/app/services/autentication.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  loggedUser:boolean=false;  //debe ser false al inicio
  myPortfolio:any;
  user:any;
  url = "/portfolioap/user";
  
  form1: FormGroup;
  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService, private formBuilder:FormBuilder) {
    this.form1 = formBuilder.group(
      {
        picUrl: [''],
        firstName:[''],
        lastName:['']
      }
    );
  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data => {
    //  console.log(data);  // FOR TESTING
      this.myPortfolio=data;
    });
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
    } else {
      this.loggedUser=false;
    }
  }

  get picUrl() {
    return this.form1.get('picUrl');
  }

  get firstName() {
    return this.form1.get('firstName');
  }

  get lastName() {
    return this.form1.get('lastName');
  }

  onSave() {
    //alert(JSON.stringify(this.form1.value)); //para pruebas
    if (this.form1.valid) {
     // console.log("form submitted!"); //para pruebas
      // let firstName = this.form1.get('firstName')?.value;
      // let lastName = this.form1.get('lastName')?.value;
      // let picUrl = this.form1.get('picUrl')?.value;
      // console.log(firstName+" "+lastName+" "+picUrl);//para pruebas
      // let data:any [] = [firstName, lastName, picUrl];
      // console.log("data: "+data);
      let data = JSON.stringify(this.form1.value);
      console.log("line 64: "+data); //TEST
      console.log(this.form1.value);
      let d = this.form1.value;
      console.log(d);

    // this.autenticationService.editUser(this.autenticationService.getUserLogged()).subscribe(
    //   data => {
    //     console.log("line 66: "+data); //TEST
    //     this.myPortfolio = data;
    //   }
    // )
    let id = this.autenticationService.getUserLogged();
    this.datosPortfolio.editUser(id).subscribe(
      // data => {
      //   console.log("line 66: "+data); //TEST
      //   this.myPortfolio = this.form1.value;
      // }
      d => {
        this.myPortfolio = d;
      }
    )

          console.log("id: "+this.autenticationService.getUserLogged()); //para pruebas
          }
    else{
      alert("Formulario inválido");
    }
  }
}

