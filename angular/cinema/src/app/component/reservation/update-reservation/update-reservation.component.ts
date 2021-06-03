import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/class/reservation';
import { ReservationService } from 'src/app/service/reservation.service';

@Component({
  selector: 'app-update-reservation',
  templateUrl: './update-reservation.component.html',
  styleUrls: ['./update-reservation.component.scss']
})
export class UpdateReservationComponent implements OnInit {

  constructor(private reservationService: ReservationService) { }

  selectedReservation: any = { "idUser":{}, "idSeat":{}, "idMovie":{}};

  reservations: Reservation[] = [];

  ngOnInit(): void {
    this.reservationService.findAll().subscribe(data => { this.reservations = data; });
  }

  onSubmit(): void{
    this.selectedReservation.idDate = this.selectedReservation.date + 'T'+this.selectedReservation.time ;
    if (confirm("Are you sure you want to update this Reservation ?")) {
      this.reservationService.save(this.selectedReservation).subscribe();
    }
    else {
      console.log("Update Reservation ABORTED");
    }
  }

}
