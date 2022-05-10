import { Component, OnInit } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  exps:Array<any> | undefined;
  exp:any;
  expts:Array<any> | undefined;
  user:any;
  openModal:boolean=false;
  url = "/portfolioap/user";

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService) { 

  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosExp().subscribe(data => {
      //console.log(data);  // FOR TESTING
      this.exps=data;
    });
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
  }

  openForm(event: Event) {
    console.log("you clicked here"); //TEST
    this.openModal = true;
  }

  closeForm(event: Event) {
    console.log("you closed"); //TEST
    //this.openModal = false;
    window.location.reload;
  }
}
