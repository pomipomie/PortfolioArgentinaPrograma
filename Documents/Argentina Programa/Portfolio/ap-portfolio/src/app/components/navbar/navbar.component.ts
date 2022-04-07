import { Component, OnInit, Output, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }

  @ViewChild("mySidenav")
  mySideNav!: ElementRef;
  openNav() {
//    console.log(this.mySideNav);
    this.mySideNav.nativeElement.style.width = "30%";
  }
  closeNav() {
    this.mySideNav.nativeElement.style.width = "0";
  }
}

// function openNav() {
//    document.getElementById("mySidenav").style.width = "30%";
//} 
//function closeNav() {
//  document.getElementById("mySidenav").style.width = "0";
//}