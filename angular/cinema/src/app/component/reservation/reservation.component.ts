import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/class/reservation';
import { ReservationService } from 'src/app/service/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {

  reservations : Reservation[] = [];

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.reservationService.findAll().subscribe(data => { this.reservations = data; });
  }

}
