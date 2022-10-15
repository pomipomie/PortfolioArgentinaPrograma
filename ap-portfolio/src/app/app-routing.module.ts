import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginformComponent } from './components/loginform/loginform.component';

const routes: Routes = [
  {path:'app',component:AppComponent },
  {path:'login',component:LoginformComponent},
  {path:'',redirectTo:'app',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
