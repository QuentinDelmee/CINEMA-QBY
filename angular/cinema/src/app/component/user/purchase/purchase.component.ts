import { Component, OnInit } from '@angular/core';
import { Purchase } from 'src/app/class/purchase';
import { Reservation } from 'src/app/class/reservation';
import { User } from 'src/app/class/user';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.scss']
})
export class PurchaseComponent implements OnInit {

  
  stringUser:any = sessionStorage.getItem('currentUser') ;
  user:User = JSON.parse(this.stringUser) ;
  //user:User = new User( {"id":56,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":57,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )
  purchases:Purchase[] = []

  constructor(private userService: UserService, private reservationService:ReservationService) { 
      
  }

  ngOnInit(): void {
    this.userService.findPurchases(this.user.id).subscribe(data => { this.purchases = data; });
  }

}
