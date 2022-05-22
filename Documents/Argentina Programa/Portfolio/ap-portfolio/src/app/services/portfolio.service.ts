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
    return this.http.get<any>(this.url+"user/1/experience");
  }

  obtenerDatosExpT():Observable<any> { 
    return this.http.get<any>(this.url+"exptype/list");
  }

  obtenerDatosEdu():Observable<any> { 
    return this.http.get<any>(this.url+"user/1/education");
  }

  obtenerDatosSki():Observable<any> {
    return this.http.get<any>(this.url+"user/1/skills");
  }

  obtenerDatosPro():Observable<any> {
    return this.http.get<any>(this.url+"user/1/projects");
  }

  editUser(user:any):Observable<any> {
    return this.http.put(this.url+"user/edit", user);
  }

  editExp(exp:any):Observable<any> {
    return this.http.put(this.url+"experience/edit", exp);
  }

  obtenerExp(id_exp:any):Observable<any> { 
    return this.http.get<any>(this.url+"experience/"+id_exp+"/search");
  }

  obtenerExpT(id_expt:any):Observable<any> { 
    return this.http.get<any>(this.url+"exptype/"+id_expt+"/search");
  }

  newExp(exp:any):Observable<any> {
    return this.http.post(this.url+"experience/new", exp);
  }

  editEdu(edu:any):Observable<any> {
    return this.http.put(this.url+"education/edit", edu);
  }

  newEdu(edu:any):Observable<any> {
    return this.http.post(this.url+"education/new", edu);
  }

  editSkill(skill:any):Observable<any> {
    return this.http.put(this.url+"skill/edit", skill);
  }

  newSkill(skill:any):Observable<any> {
    return this.http.post(this.url+"skill/new", skill);
  }

  editPro(proj:any):Observable<any> {
    return this.http.put(this.url+"project/edit", proj);
  }

  newPro(proj:any):Observable<any> {
    return this.http.post(this.url+"project/new", proj);
  }

  getPro(id_projects:any):Observable<any> {
    return this.http.get<any>(this.url+"project/"+id_projects+"/search");
  }
}