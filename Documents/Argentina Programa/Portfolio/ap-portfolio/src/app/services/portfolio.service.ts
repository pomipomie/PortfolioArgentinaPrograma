import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  url:string="/portfolioap/" // poner URL API!!!
  constructor(private http:HttpClient) { }

  obtenerDatos():Observable<any> { 
    return this.http.get<any>(this.url+"user");   // this.url+"user"
  }
}
