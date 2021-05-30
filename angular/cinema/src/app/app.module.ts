import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { DataComponent } from './component/data/data.component';
import { HowToComeComponent } from './component/how-to-come/how-to-come.component';
import { MovieComponent } from './component/movie/movie.component';
import { ProfilComponent } from './component/profil/profil.component';
import { ReservationComponent } from './component/reservation/reservation.component';
import { SignInComponent } from './component/sign-in/sign-in.component';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { TimeTableComponent } from './component/time-table/time-table.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './module/material.module' ;
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CreateMovieComponent } from './component/movie/create-movie/create-movie.component';
import { UpdateMovieComponent } from './component/movie/update-movie/update-movie.component';
import { DeleteMovieComponent } from './component/movie/delete-movie/delete-movie.component';
import { DeleteProfilComponent } from './component/profil/delete-profil/delete-profil.component';
import { UpdateProfilComponent } from './component/profil/update-profil/update-profil.component';
import { CreateProfilComponent } from './component/profil/create-profil/create-profil.component';
import { CreateReservationComponent } from './component/reservation/create-reservation/create-reservation.component';
import { UpdateReservationComponent } from './component/reservation/update-reservation/update-reservation.component';
import { DeleteReservationComponent } from './component/reservation/delete-reservation/delete-reservation.component';
import { DeleteTimeTableComponent } from './component/time-table/delete-time-table/delete-time-table.component';
import { UpdateTimeTableComponent } from './component/time-table/update-time-table/update-time-table.component';
import { CreateTimeTableComponent } from './component/time-table/create-time-table/create-time-table.component';



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
    FooterComponent,
    CreateMovieComponent,
    UpdateMovieComponent,
    DeleteMovieComponent,
    DeleteProfilComponent,
    UpdateProfilComponent,
    CreateProfilComponent,
    CreateReservationComponent,
    UpdateReservationComponent,
    DeleteReservationComponent,
    DeleteTimeTableComponent,
    UpdateTimeTableComponent,
    CreateTimeTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
