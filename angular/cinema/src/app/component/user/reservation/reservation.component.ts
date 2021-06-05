import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/class/reservation';
import { User } from 'src/app/class/user';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {


  stringUser:any = sessionStorage.getItem('currentUser') ;
  user:User = JSON.parse(this.stringUser) ;
  //user:User = new User( {"id":56,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":57,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )


  constructor(private userService: UserService, private reservationService:ReservationService) { 
      
  }

  selectedReservation: any = { "idUser":{}, "idSeat":{}, "idMovie":{}};

  reservations: Reservation[] = [];

  ngOnInit(): void {
    this.userService.findReservations(this.user.id).subscribe(data => { this.reservations = data; });
  }

}
