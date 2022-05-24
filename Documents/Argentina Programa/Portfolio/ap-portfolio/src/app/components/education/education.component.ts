import { Component, OnInit } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  edus:Array<any> | undefined;
  edu:any;
  openModal:boolean=false;
  openModalN:boolean=false;

  constructor(private datosPortfolio:PortfolioService, private autenticationService:AutenticationService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosEdu().subscribe(data => {
      //console.log(data);  // FOR TESTING
      this.edus=data;
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

  deleteEdu(id_educ: any) {
    console.log("deleting..."); //TEST
    this.datosPortfolio.deleteEdu(id_educ).subscribe();
    window.location.reload();
  }

}
