import { Component, OnInit } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  loggedUser:boolean=false;  //debe ser false al inicio
  projs:Array<any> | undefined;
  proj:any;
  openModal:boolean=false;
  openModalN:boolean=false;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService) { }

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

  openForm(event: Event) {
    this.openModal = true;
  }

  openFormN(event: Event) {
    this.openModalN = true;
  }

  deleteProj(id_projects: any) {
    this.datosPortfolio.deletePro(id_projects).subscribe();
    window.location.reload();
  }

}
