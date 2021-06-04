import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/class/reservation';
import { ReservationService } from 'src/app/service/reservation.service';

@Component({
  selector: 'app-delete-reservation',
  templateUrl: './delete-reservation.component.html',
  styleUrls: ['./delete-reservation.component.scss']
})
export class DeleteReservationComponent implements OnInit {

  constructor(private reservationService: ReservationService) { 
      this.reservationService.findAll().subscribe(data => { this.reservations = data; });
  }

  selectedReservation: any = { "idUser":{}, "idSeat":{}, "idMovie":{}};

  reservations: Reservation[] = [];

  ngOnInit(): void {
    
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
