import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/class/reservation';
import { User } from 'src/app/class/user';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-delete-reservation',
  templateUrl: './delete-reservation.component.html',
  styleUrls: ['./delete-reservation.component.scss']
})
export class DeleteReservationComponent implements OnInit {

  user:User = new User( {"id":56,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":57,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )


  constructor(private userService: UserService, private reservationService:ReservationService) { 
      
  }

  selectedReservation: any = { "idUser":{}, "idSeat":{}, "idMovie":{}};

  reservations: Reservation[] = [];

  ngOnInit(): void {
    this.userService.findReservations(this.user.id).subscribe(data => { this.reservations = data; });
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Reservation ?")) {
      console.log(this.selectedReservation) ;
      this.reservationService.delete(this.selectedReservation.id).subscribe() ;
    }
    else {
      console.log("Delete Reservation ABORTED");
    }
  }

  delete(resa:Reservation,index:number)
  {
    if (confirm("Are you sure you want to delete this Reservation ?")) {
      this.reservations.slice(index);
      this.reservationService.delete(resa.id).subscribe() ;
    }
    else {
      console.log("Delete Reservation ABORTED");
    }
    
  }

}
