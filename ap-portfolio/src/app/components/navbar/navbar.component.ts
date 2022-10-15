import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { AutenticationService } from 'src/app/services/autentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public bulbclass : string = 'bi bi-lightbulb-fill';
  public onoff : string = 'bi bi-toggle-off';
  
  loggedUser:boolean=false;  //debe ser false al inicio

  constructor(private autenticationService:AutenticationService) { }

  ngOnInit(): void {
    if (this.autenticationService.getUserLogged() != '') {
    this.loggedUser=true;
   } else {
    this.loggedUser=false;
   }
  }

  
  logOut(): void {
    this.autenticationService.logOut(); 
  }
  
  @ViewChild("mySidenav")
  mySideNav!: ElementRef;
  openNav() {
    this.mySideNav.nativeElement.style.width = "30%";
  }
  closeNav() {
    this.mySideNav.nativeElement.style.width = "0";
  }

  toggle() :any {
  if (this.bulbclass === 'bi bi-lightbulb-fill') {
    this.bulbclass = 'bi bi-lightbulb';
    document.body.classList.toggle('dark-theme');
  } else {
    this.bulbclass = 'bi bi-lightbulb-fill';
    document.body.classList.toggle('dark-theme');
  }}

  gradient() :any {
    if (this.onoff === 'bi bi-toggle-off') {
      this.onoff = 'bi bi-toggle-on';
      document.body.classList.toggle('gradientmode');
    } else {
      this.onoff = 'bi bi-toggle-off';
      document.body.classList.toggle('gradientmode');
    }}
}
