import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DataComponent } from './data/data.component';
import { HowToComeComponent } from './how-to-come/how-to-come.component';
import { MovieComponent } from './movie/movie.component';
import { ProfilComponent } from './profil/profil.component';
import { ReservationComponent } from './reservation/reservation.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { TimeTableComponent } from './time-table/time-table.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MaterialModule } from './material.module' ;


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DataComponent,
    HowToComeComponent,
    MovieComponent,
    ProfilComponent,
    ReservationComponent,
    SignInComponent,
    SignUpComponent,
    TimeTableComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
