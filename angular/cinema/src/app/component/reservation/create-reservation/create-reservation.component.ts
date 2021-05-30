import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/class/reservation';
import { ReservationService } from 'src/app/service/reservation.service';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.scss']
})
export class CreateReservationComponent implements OnInit {

  reservationJSON: any = {};

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.reservationJSON.idUser = { "id":this.reservationJSON.idUser } ;
    this.reservationJSON.idSeat = { "id":this.reservationJSON.idSeat } ;
    
    if (confirm("Are you sure you want to create this Reservation ?")) {
      let toPost: Reservation = new Reservation(this.reservationJSON);
      this.reservationService.save(toPost).subscribe();
    }
    else {
      console.log("New Reservation ABORTED");
    }
  }

}
