import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/class/session';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-create-time-table',
  templateUrl: './create-time-table.component.html',
  styleUrls: ['./create-time-table.component.scss']
})
export class CreateTimeTableComponent implements OnInit {

  sessionJSON: any = {};

  constructor(private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.sessionJSON.idUser = { "id":this.sessionJSON.idUser } ;
    this.sessionJSON.idSeat = { "id":this.sessionJSON.idSeat } ;
    
    if (confirm("Are you sure you want to create this Session ?")) {
      let toPost: Session = new Session(this.sessionJSON);
      this.sessionService.save(toPost).subscribe();
    }
    else {
      console.log("New Session ABORTED");
    }
  }
}
