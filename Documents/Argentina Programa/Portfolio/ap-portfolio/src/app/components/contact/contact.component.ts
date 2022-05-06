import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  loggedUser:boolean=true;  //debe ser false al inicio

  constructor() { }

  ngOnInit(): void {
  }

}
