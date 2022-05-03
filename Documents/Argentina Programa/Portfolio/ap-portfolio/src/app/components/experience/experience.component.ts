import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  exps:Array<any> | undefined;

  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosExp().subscribe(data => {
      console.log(data);  // FOR TESTING
      this.exps=data;
    });
  }

}
