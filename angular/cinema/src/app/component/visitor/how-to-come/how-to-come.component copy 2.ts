import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
  import 'leaflet-routing-machine';

@Component({
  selector: 'app-how-to-come',
  templateUrl: './how-to-come.component.html',
  styleUrls: ['./how-to-come.component.scss']
})
export class HowToComeComponent implements AfterViewInit {

  private map:any;

  private initMap(): void {
    this.map = L.map('map', {
      center: [ 39.8282, -98.5795 ],
      zoom: 3
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }

  constructor() { }

  ngAfterViewInit(): void {
    this.initMap();
  }
}
