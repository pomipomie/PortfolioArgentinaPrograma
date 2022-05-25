import { Component, OnInit } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  loggedUser:boolean=false;  //debe ser false al inicio
  exps:Array<any> | undefined;
  exp:any;
  expts:Array<any> | undefined;
  user:any;
  openModal:boolean=false;
  openModalN:boolean=false;
  url = "/portfolioap/user";

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService) { 

  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosExp().subscribe(data => {
      this.exps=data;
    });
    if (this.autenticationService.getUserLogged() != '') {
      this.loggedUser=true;
     } else {
      this.loggedUser=false;
     }
  }

  openForm(event: Event) {
    this.openModal = true;
  }

  openFormN(event: Event) {
    this.openModalN = true;
  }

  deleteExp(id_exp: any) {
    this.datosPortfolio.deleteExp(id_exp).subscribe();
    window.location.reload();
  }
}
