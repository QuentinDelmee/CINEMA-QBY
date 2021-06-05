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
import { DeleteReservationComponent } from './component/user/delete-reservation/delete-reservation.component';

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
import { AllUserComponent } from './component/admin/all-user/all-user.component';
import { ProductComponent } from './component/visitor/product/product.component';
import { UpdatePasswordComponent } from './component/user/update-password/update-password.component';
import { PurchaseComponent } from './component/user/purchase/purchase.component';
import { CreatePurchaseComponent } from './component/admin/create-purchase/create-purchase.component';
import { UpdatePurchaseComponent } from './component/admin/update-purchase/update-purchase.component';
import { OpinionComponent } from './component/user/opinion/opinion.component';
import { CommentaryComponent } from './component/user/commentary/commentary.component';

let access: number = Number(sessionStorage.getItem('access'));

let routes: Routes = [
  /* VISITOR SECTION */
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'movie', component: MovieComponent },
  { path: 'timetable', component: TimeTableComponent },
  { path: 'products', component: ProductComponent },
  { path: 'signin', component: SignInComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'quizz-page', component: QuizzComponent },
  { path: 'quizz-on-phone', component: QuizzOnPhoneComponent },
  { path: 'how-to-come', component: HowToComeComponent },
  /* USER SECTION */
  { path: 'user', component: UserComponent },
  { path: 'user/password', component: UpdatePasswordComponent },
  { path: 'user/profil', component: ProfilComponent },
  { path: 'user/profil/update', component: UpdateProfilComponent },
  { path: 'user/reservation', component: ReservationComponent },
  { path: 'user/reservation/create', component: CreateReservationComponent },
  { path: 'user/reservation/delete', component: DeleteReservationComponent },
  { path: 'user/purchase', component: PurchaseComponent },
  { path: 'user/comment', component: CommentaryComponent },
  { path: 'user/opinion', component: OpinionComponent },
  /* ADMIN SECTION */
  { path: 'admin', component: AdminComponent },
  { path: 'admin/timetable/create', component: CreateTimeTableComponent },
  { path: 'admin/timetable/update', component: UpdateTimeTableComponent },
  { path: 'admin/timetable/delete', component: DeleteTimeTableComponent },
  { path: 'admin/user/all', component: AllUserComponent },
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
  { path: 'admin/purchase/create', component: CreatePurchaseComponent },
  { path: 'admin/purchase/update', component: UpdatePurchaseComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
