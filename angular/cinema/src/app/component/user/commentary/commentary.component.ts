import { Component, OnInit } from '@angular/core';
import { Commentary } from 'src/app/class/commentary';
import { Purchase } from 'src/app/class/purchase';
import { Reservation } from 'src/app/class/reservation';
import { User } from 'src/app/class/user';
import { CommentaryService } from 'src/app/service/commentary.service';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-commentary',
  templateUrl: './commentary.component.html',
  styleUrls: ['./commentary.component.scss']
})
export class CommentaryComponent implements OnInit {

  
  stringUser:any = sessionStorage.getItem('currentUser') ;
  user:User = JSON.parse(this.stringUser) ;
  //user:User = new User( {"id":56,"pseudo":"MoshGoss","pwd":"azertyuiop","idPerson":{"id":57,"firstName":"Quentin","familyName":"Delmée","birthdate":"1991-03-09","genre":"Male","city":"Nantes","email":"quentin.delmee@qby.fr",} ,"idSecurityLevel":{"id":42,"role":"client","description":"blablabla"}} )
  comments:Commentary[] = [] ;

  constructor(private userService: UserService, private commentaryService:CommentaryService) { 
      
  }

  ngOnInit(): void {
    this.userService.findComments(this.user.id).subscribe(data => { this.comments = data; });
  }

  delete(comment:Commentary,index:number) {
    if (confirm("Are you sure you want to delete this comment ?")) {
      this.comments.splice(index,1);
      console.log(this.comments) ;
      this.commentaryService.delete(comment.id).subscribe() ;
      window.location.reload() ;
    }
    else {
      console.log("Delete Reservation ABORTED");
    }
  }

  trackComment(index:number,comment:Commentary)
  {
    return comment.id ;
  }

}
