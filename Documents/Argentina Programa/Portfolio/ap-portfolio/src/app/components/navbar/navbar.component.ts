import { Component, OnInit, Output, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public bulbclass : string = 'bi bi-lightbulb-fill';
  
  constructor() { }

  ngOnInit(): void {
    
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
}
