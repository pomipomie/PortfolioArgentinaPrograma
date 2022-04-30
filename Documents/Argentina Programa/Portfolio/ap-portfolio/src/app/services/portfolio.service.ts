import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  url:string="/portfolioap/" // poner URL API!!!
  constructor(private http:HttpClient) { 
    console.log("El servicio está corriendo");
  }

  obtenerDatos():Observable<any> { 
    return this.http.get<any>(this.url+"user"+"/1/search");   // this.url+"user"
  }

  obtenerDatosExp():Observable<any> { 
    return this.http.get<any>(this.url+"experience"+"/3/search");
  }

  obtenerDatosEdu():Observable<any> { 
    return this.http.get<any>(this.url+"education"+"/0/search");
  }

  obtenerDatosSki():Observable<any> { 
    return this.http.get<any>(this.url+"skill"+"/11/search");
  }
}
