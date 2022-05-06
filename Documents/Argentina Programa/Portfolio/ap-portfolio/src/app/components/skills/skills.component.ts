import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio
  skills:Array<any> | undefined;

  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatosSki().subscribe(data => {
      console.log(data);  // FOR TESTING
      this.skills=data;
    });
  }

}
