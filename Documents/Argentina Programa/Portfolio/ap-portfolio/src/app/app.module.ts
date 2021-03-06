import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BannerComponent } from './components/banner/banner.component';
import { AboutComponent } from './components/about/about.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { EducationComponent } from './components/education/education.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { ContactComponent } from './components/contact/contact.component';
import { LoginformComponent } from './components/loginform/loginform.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http'
import { ReactiveFormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { ExpformComponent } from './components/expform/expform.component';
import { NewexpformComponent } from './components/newexpform/newexpform.component';
import { EduformComponent } from './components/eduform/eduform.component';
import { NeweduformComponent } from './components/neweduform/neweduform.component';
import { NewskiformComponent } from './components/newskiform/newskiform.component';
import { SkiformComponent } from './components/skiform/skiform.component';
import { ProformComponent } from './components/proform/proform.component';
import { NewproformComponent } from './components/newproform/newproform.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BannerComponent,
    AboutComponent,
    ExperienceComponent,
    EducationComponent,
    SkillsComponent,
    ProjectsComponent,
    ContactComponent,
    LoginformComponent,
    FooterComponent,
    ExpformComponent,
    NewexpformComponent,
    EduformComponent,
    NeweduformComponent,
    NewskiformComponent,
    SkiformComponent,
    ProformComponent,
    NewproformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
