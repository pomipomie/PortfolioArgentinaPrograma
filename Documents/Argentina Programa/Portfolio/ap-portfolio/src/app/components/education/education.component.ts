import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  myPortfolio:any;

  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosEdu().subscribe(data => {
      console.log(data);  // FOR TESTING
      this.myPortfolio=data;
    });
  }

}
