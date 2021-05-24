import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-how-to-come',
  templateUrl: './how-to-come.component.html',
  styleUrls: ['./how-to-come.component.scss']
})
export class HowToComeComponent implements AfterViewInit {
  macarte:any ;

  calculateRouting(position:any)
{
    const latitude:any = position.coords.latitude ;
    const longitude:any = position.coords.longitude ;
    

    L.Routing.control({

        
        // Nous personnalisons le tracé
        lineOptions: {
            styles: [{color: '#ff8f00', opacity: 1, weight: 7}]
        },
    
        // Nous personnalisons la langue et le moyen de transport
        router: new L.Routing.osrmv1({
            language: 'fr',
            profile: 'car', // car, bike, foot
        }),

        waypoints: [
            L.latLng(latitude, longitude),
            L.latLng(47.2237252,-1.6263037)
        ],
        geocoder: L.Control.Geocoder.nominatim()
    }).addTo(this.macarte);

    // setTimeout(calculateRouting,5000) ;
}
  constructor() { }

  ngAfterViewInit(): void {
    this.macarte = L.map('carte').setView([47.2237252,-1.6263037],15)

    // On charge les tuiles depuis un serveur au choix, ici OpenStreetMap France
    L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
        attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
        minZoom: 1,
        maxZoom: 20
    }).addTo(this.macarte)

    

    // Cette méthode est à insérer juste après avoir initialisé la carte
    // L.Routing.control({
    //     geocoder: L.Control.Geocoder.nominatim()
    // }).addTo(macarte)

    let cinemaMarker = L.marker([47.2237252,-1.6263037], 'CINEMA QBY') ;
    cinemaMarker.addTo(this.macarte) ;


    navigator.geolocation.getCurrentPosition( this.calculateRouting );
  }
}
