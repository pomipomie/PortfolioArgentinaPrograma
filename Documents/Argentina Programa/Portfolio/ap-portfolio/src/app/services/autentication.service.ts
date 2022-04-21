import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map }  from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AutenticationService {
  url = "insertar url del login";
  currentUserSubject: BehaviorSubject<any>;  //currentUserSubject tiene que ser inicializado!
  constructor(private http:HttpClient) { 
    this.currentUserSubject= new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('currentUser') || '{}'));
  }

  LogIn(credentials:any):Observable<any> {
    return this.http.post(this.url, credentials).pipe(map(data=>{
      sessionStorage.setItem('currentUser', JSON.stringify(data));
      return data;
    }))
  }
}
