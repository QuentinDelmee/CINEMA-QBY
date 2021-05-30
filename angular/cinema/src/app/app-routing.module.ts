import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './component/home/home.component';
import { DataComponent } from './component/data/data.component';
import { HowToComeComponent } from './component/how-to-come/how-to-come.component';
import { MovieComponent } from './component/movie/movie.component';
import { ProfilComponent } from './component/profil/profil.component';
import { ReservationComponent } from './component/reservation/reservation.component';
import { SignInComponent } from './component/user/sign-in/sign-in.component';
import { SignUpComponent } from './component/user/sign-up/sign-up.component';
import { TimeTableComponent } from './component/time-table/time-table.component';
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
import { CreateUser, CreateUserComponent } from './component/user/create-user/create-user.component';
import { UpdateUser, UpdateUserComponent } from './component/user/update-user/update-user.component';
import { DeleteUser, DeleteUserComponent } from './component/user/delete-user/delete-user.component';

const routes: Routes = [
  { path: 'home-page', component: HomeComponent },
  { path: 'data-page', component: DataComponent },
  { path: 'how-to-come-page', component: HowToComeComponent },
  { path: 'movie-page', component: MovieComponent },
  { path: 'movie-page/create', component: CreateMovieComponent },
  { path: 'movie-page/update', component: UpdateMovieComponent },
  { path: 'movie-page/delete', component: DeleteMovieComponent },
  { path: 'profil-page', component: ProfilComponent },
  { path: 'profil-page/create', component: CreateProfilComponent },
  { path: 'profil-page/update', component: UpdateProfilComponent },
  { path: 'profil-page/delete', component: DeleteProfilComponent },
  { path: 'reservation-page', component: ReservationComponent },
  { path: 'reservation-page/create', component: CreateReservationComponent },
  { path: 'reservation-page/update', component: UpdateReservationComponent },
  { path: 'reservation-page/delete', component: DeleteReservationComponent },
  { path: 'signin-page', component: SignInComponent },
  { path: 'signup-page', component: SignUpComponent },
  { path: 'timetable-page', component: TimeTableComponent },
  { path: 'timetable-page/create', component: CreateTimeTableComponent },
  { path: 'timetable-page/update', component: UpdateTimeTableComponent },
  { path: 'timetable-page/delete', component: DeleteTimeTableComponent },
  { path: 'user-page/create', component: CreateUserComponent },
  { path: 'user-page-page/update', component: UpdateUserComponent },
  { path: 'user-page-page/delete', component: DeleteUserComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
