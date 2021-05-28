import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './component/home/home.component';
import { DataComponent } from './component/data/data.component';
import { HowToComeComponent } from './component/how-to-come/how-to-come.component';
import { MovieComponent } from './component/movie/movie.component';
import { ProfilComponent } from './component/profil/profil.component';
import { ReservationComponent } from './component/reservation/reservation.component';
import { SignInComponent } from './component/sign-in/sign-in.component';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { TimeTableComponent } from './component/time-table/time-table.component';

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
