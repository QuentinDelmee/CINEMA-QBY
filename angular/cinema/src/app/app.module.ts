import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/visitor/home/home.component';
import { DataComponent } from './component/admin/data/data.component';
import { HowToComeComponent } from './component/visitor/how-to-come/how-to-come.component';
import { MovieComponent } from './component/visitor/movie/movie.component';
import { ProfilComponent } from './component/user/profil/profil.component';
import { ReservationComponent } from './component/user/reservation/reservation.component';
import { SignInComponent } from './component/visitor/sign-in/sign-in.component';
import { SignUpComponent } from './component/visitor/sign-up/sign-up.component';
import { TimeTableComponent } from './component/visitor/time-table/time-table.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './module/material.module' ;
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CreateMovieComponent } from './component/admin/create-movie/create-movie.component';
import { UpdateMovieComponent } from './component/admin/update-movie/update-movie.component';
import { DeleteMovieComponent } from './component/admin/delete-movie/delete-movie.component';
import { UpdateProfilComponent } from './component/user/update-profil/update-profil.component';
import { CreateReservationComponent } from './component/user/create-reservation/create-reservation.component';
import { DeleteReservationComponent } from './component/admin/delete-reservation/delete-reservation.component';
import { DeleteTimeTableComponent } from './component/admin/delete-time-table/delete-time-table.component';
import { UpdateTimeTableComponent } from './component/admin/update-time-table/update-time-table.component';
import { CreateTimeTableComponent } from './component/admin/create-time-table/create-time-table.component';
import { UserComponent } from './component/user/user.component';
import { CreateUserComponent } from './component/admin/create-user/create-user.component';
import { UpdateUserComponent } from './component/user/update-user/update-user.component';
import { DeleteUserComponent } from './component/admin/delete-user/delete-user.component';
import { QuizzComponent } from './component/visitor/quizz/quizz.component';
import { QuizzOnPhoneComponent } from './component/visitor/quizz-on-phone/quizz-on-phone.component';
import { AdminComponent } from './component/admin/admin.component';
import { ProductComponent } from './component/visitor/product/product.component';
import { CreateProductComponent } from './component/admin/create-product/create-product.component';
import { UpdateProductComponent } from './component/admin/update-product/update-product.component';
import { DeleteProductComponent } from './component/admin/delete-product/delete-product.component';



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
    UpdateProfilComponent,
    CreateReservationComponent,
    DeleteReservationComponent,
    DeleteTimeTableComponent,
    UpdateTimeTableComponent,
    CreateTimeTableComponent,
    UserComponent,
    CreateUserComponent,
    UpdateUserComponent,
    DeleteUserComponent,
    QuizzComponent,
    QuizzOnPhoneComponent,
    AdminComponent,
    ProductComponent,
    CreateProductComponent,
    UpdateProductComponent,
    DeleteProductComponent
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
