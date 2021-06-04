import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './component/visitor/home/home.component';
import { DataComponent } from './component/admin/data/data.component';
import { HowToComeComponent } from './component/visitor/how-to-come/how-to-come.component';

import { MovieComponent } from './component/visitor/movie/movie.component';
import { CreateMovieComponent } from './component/admin/create-movie/create-movie.component';
import { UpdateMovieComponent } from './component/admin/update-movie/update-movie.component';
import { DeleteMovieComponent } from './component/admin/delete-movie/delete-movie.component';

import { ProfilComponent } from './component/user/profil/profil.component';
import { UpdateProfilComponent } from './component/user/update-profil/update-profil.component';

import { ReservationComponent } from './component/user/reservation/reservation.component';
import { CreateReservationComponent } from './component/user/create-reservation/create-reservation.component';
import { DeleteReservationComponent } from './component/admin/delete-reservation/delete-reservation.component';

import { TimeTableComponent } from './component/visitor/time-table/time-table.component';
import { DeleteTimeTableComponent } from './component/admin/delete-time-table/delete-time-table.component';
import { UpdateTimeTableComponent } from './component/admin/update-time-table/update-time-table.component';
import { CreateTimeTableComponent } from './component/admin/create-time-table/create-time-table.component';

import { UserComponent } from './component/user/user.component';
import { CreateUserComponent } from './component/admin/create-user/create-user.component';
import { UpdateUserComponent } from './component/user/update-user/update-user.component';
import { DeleteUserComponent } from './component/admin/delete-user/delete-user.component';
import { SignInComponent } from './component/visitor/sign-in/sign-in.component';
import { SignUpComponent } from './component/visitor/sign-up/sign-up.component';

import { QuizzComponent } from './component/visitor/quizz/quizz.component'
import { QuizzOnPhoneComponent } from './component/visitor/quizz-on-phone/quizz-on-phone.component'
import { AdminComponent } from './component/admin/admin.component';
import { CreateProductComponent } from './component/admin/create-product/create-product.component';
import { UpdateProductComponent } from './component/admin/update-product/update-product.component';
import { DeleteProductComponent } from './component/admin/delete-product/delete-product.component';

let access: number = Number(sessionStorage.getItem('access'));

let routes:Routes = [] ;

if (access == 0) {
  routes = [

    /* VISITOR SECTION */
    { path: '', component: HomeComponent },
    { path: 'home-page', component: HomeComponent },
    { path: 'movie-page', component: MovieComponent },
    { path: 'timetable-page', component: TimeTableComponent },
    { path: 'signin', component: SignInComponent },
    { path: 'signup', component: SignUpComponent },
    { path: 'quizz-page', component: QuizzComponent },
    { path: 'quizz-on-phone', component: QuizzOnPhoneComponent },
    { path: 'how-to-come-page', component: HowToComeComponent },
    // 'movie-page/description
  ] ;
}
else if (access == 1) {
  routes = [
    /* VISITOR SECTION */
    { path: '', component: HomeComponent },
    { path: 'home-page', component: HomeComponent },
    { path: 'movie-page', component: MovieComponent },
    { path: 'timetable-page', component: TimeTableComponent },
    { path: 'signin', component: SignInComponent },
    { path: 'signup', component: SignUpComponent },
    { path: 'quizz-page', component: QuizzComponent },
    { path: 'quizz-on-phone', component: QuizzOnPhoneComponent },
    { path: 'how-to-come-page', component: HowToComeComponent },

    /* USER SECTION */
    { path: 'user/profil', component: ProfilComponent },
    { path: 'user/profil/update', component: UpdateProfilComponent },
    { path: 'user/reservation', component: ReservationComponent },
    { path: 'user/reservation/create', component: CreateReservationComponent },
    { path: 'user/reservation/delete', component: DeleteReservationComponent },
  ] ;
}
else if (access == 6) {
  routes = [
    { path: '', component: AdminComponent },
    { path: 'home-page', component: HomeComponent },
    { path: 'movie-page', component: MovieComponent },
    { path: 'timetable-page', component: TimeTableComponent },
    { path: 'signin', component: SignInComponent },
    { path: 'signup', component: SignUpComponent },
    { path: 'quizz-page', component: QuizzComponent },
    { path: 'quizz-on-phone', component: QuizzOnPhoneComponent },
    { path: 'how-to-come-page', component: HowToComeComponent },

    /* USER SECTION */
    { path: 'user/profil', component: ProfilComponent },
    { path: 'user/profil/update', component: UpdateProfilComponent },
    { path: 'user/reservation', component: ReservationComponent },
    { path: 'user/reservation/create', component: CreateReservationComponent },
    { path: 'user/reservation/delete', component: DeleteReservationComponent },
  /* ADMIN SECTION */
  { path: 'admin', component: AdminComponent },
  { path: 'admin/timetable/create', component: CreateTimeTableComponent },
  { path: 'admin/timetable/update', component: UpdateTimeTableComponent },
  { path: 'admin/timetable/delete', component: DeleteTimeTableComponent },
  { path: 'admin/user/all', component: UserComponent },
  { path: 'admin/user/create', component: CreateUserComponent },
  { path: 'admin/user/update', component: UpdateUserComponent },
  { path: 'admin/user/delete', component: DeleteUserComponent },
  { path: 'admin/movie/create', component: CreateMovieComponent },
  { path: 'admin/movie/update', component: UpdateMovieComponent },
  { path: 'admin/movie/delete', component: DeleteMovieComponent },
  { path: 'admin/product/create', component: CreateProductComponent },
  { path: 'admin/product/update', component: UpdateProductComponent },
  { path: 'admin/product/delete', component: DeleteProductComponent },
  { path: 'admin/data', component: DataComponent },

];
}

  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
