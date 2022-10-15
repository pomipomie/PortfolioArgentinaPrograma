import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map }  from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AutenticationService {
  url = "/portfolioap/user";
  currentUserSubject: BehaviorSubject<any>;  //currentUserSubject tiene que ser inicializado!
  constructor(private http:HttpClient, private cookies:CookieService) { 
    this.currentUserSubject= new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('currentUser') || '{}'));
  //  console.log("autservice is running"+JSON.stringify(this.currentUserSubject)); // for testing
  }

  logIn(user:any):Observable<any> {
    return this.http.post(this.url+"/login", user).pipe(map(data=>{
      sessionStorage.setItem('currentUser', JSON.stringify(data));
    //  console.log("login is running"+JSON.stringify(data)); // for testing
      return data;
    }))
  }

  getUser(id:number):Observable<any>{
    return this.http.get(this.url+"/"+id+"/search");
  }

  setToken(token:string) {
    this.cookies.set("token", token);
  }
  
  getToken(){
    return this.cookies.get("token");
  }

  deleteToken(){
    this.cookies.delete("token");
  }

  logOut() {
    this.deleteToken();
    sessionStorage.removeItem('currentUser');
  }

  getUserLogged(){
    const token = this.getToken();
    return token;
  }

  editUser(user:any):Observable<any> {
    return this.http.put(this.url+"/edit", user);
  }

/*   get AuthUser() {
    return this.currentUserSubject.value;
  } */

}
