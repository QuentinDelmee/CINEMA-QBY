import { Component, OnInit } from '@angular/core';
import { Opinion } from 'src/app/class/opinion';
import { Purchase } from 'src/app/class/purchase';
import { Reservation } from 'src/app/class/reservation';
import { User } from 'src/app/class/user';
import { OpinionService } from 'src/app/service/opinion.service';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-opinion',
  templateUrl: './opinion.component.html',
  styleUrls: ['./opinion.component.scss']
})
export class OpinionComponent implements OnInit {

  
  stringUser:any = sessionStorage.getItem('currentUser') ;
  user:User = JSON.parse(this.stringUser) ;
  //user:User = new User( {"id":56,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":57,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )
  opinions:Opinion[] = [] ;

  constructor(private userService: UserService, private opinionService:OpinionService) { 
      
  }

  ngOnInit(): void {
    this.userService.findOpinions(this.user.id).subscribe(data => { this.opinions = data; });
  }

  delete(opinion:Opinion,index:number) {
    if (confirm("Are you sure you want to delete this opinion ?")) {
      this.opinions.splice(index,1);
      console.log(this.opinions) ;
      this.opinionService.delete(opinion.id).subscribe() ;
      window.location.reload() ;
    }
    else {
      console.log("Delete Reservation ABORTED");
    }
  }

  trackOpinion(index:number,opinion:Opinion)
  {
    return opinion.id ;
  }

}
