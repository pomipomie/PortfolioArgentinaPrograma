import { Component, OnInit } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  skills:Array<any> | undefined;
  openModal:boolean=false;
  openModalN:boolean=false;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosSki().subscribe(data => {
      console.log(data);  // FOR TESTING
      this.skills=data;
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

  openFormN(event: Event) {
    console.log("you clicked here!!"); //TEST
    this.openModalN = true;
  }
  
  deleteSkill(id_skills: any) {
    console.log("deleting..."); //TEST
    this.datosPortfolio.deleteSkill(id_skills).subscribe();
    window.location.reload();
  }

}