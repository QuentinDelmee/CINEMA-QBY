import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { DataComponent } from './data/data.component';
import { HowToComeComponent } from './how-to-come/how-to-come.component';
import { MovieComponent } from './movie/movie.component';
import { ProfilComponent } from './profil/profil.component';
import { ReservationComponent } from './reservation/reservation.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { TimeTableComponent } from './time-table/time-table.component';

const routes: Routes = [
  { path: 'home-page', component: HomeComponent },
  { path: 'data-page', component: DataComponent },
  { path: 'how-to-come-page', component: HowToComeComponent },
  { path: 'movie-page', component: MovieComponent },
  { path: 'profil-page', component: ProfilComponent },
  { path: 'reservation-page', component: ReservationComponent },
  { path: 'signin-page', component: SignInComponent },
  { path: 'signup-page', component: SignUpComponent },
  { path: 'timetable-page', component: TimeTableComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
