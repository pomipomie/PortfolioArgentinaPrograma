import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  url:string="https://portfolio-ap-mxb.herokuapp.com/portfolioap/";
  constructor(private http:HttpClient) { 
    console.log("El servicio está corriendo");
  }

  obtenerDatos():Observable<any> { 
    return this.http.get<any>(this.url+"user"+"/1/search");
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

  obtenerDatosEduT():Observable<any> { 
    return this.http.get<any>(this.url+"educt/list");
  }

  obtenerDatosSki():Observable<any> {
    return this.http.get<any>(this.url+"user/1/skills");
  }

  obtenerDatosSkillT():Observable<any> {
    return this.http.get<any>(this.url+"skilltype/list");
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

  deleteExp(id_exp:any):Observable<any> {
    return this.http.delete(this.url+"experience/"+id_exp+"/delete");
  }

  editEdu(edu:any):Observable<any> {
    return this.http.put(this.url+"education/edit", edu);
  }

  newEdu(edu:any):Observable<any> {
    return this.http.post(this.url+"education/new", edu);
  }

  obtenerEdu(id_educ:any):Observable<any> { 
    return this.http.get<any>(this.url+"education/"+id_educ+"/search");
  }

  deleteEdu(id_educ:any):Observable<any> {
    return this.http.delete(this.url+"education/"+id_educ+"/delete");
  }

  obtenerEducT(id_educt:any):Observable<any> { 
    return this.http.get<any>(this.url+"educt/"+id_educt+"/search");
  }

  editSkill(skill:any):Observable<any> {
    return this.http.put(this.url+"skill/edit", skill);
  }

  newSkill(skill:any):Observable<any> {
    return this.http.post(this.url+"skill/new", skill);
  }

  obtenerSkill(id_skills:any):Observable<any> { 
    return this.http.get<any>(this.url+"skill/"+id_skills+"/search");
  }

  deleteSkill(id_skills:any):Observable<any> {
    return this.http.delete(this.url+"skill/"+id_skills+"/delete");
  }

  obtenerSkillT(id_skillt:any):Observable<any> { 
    return this.http.get<any>(this.url+"skilltype/"+id_skillt+"/search");
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

  deletePro(id_projects:any):Observable<any> {
    return this.http.delete(this.url+"project/"+id_projects+"/delete");
  }
}