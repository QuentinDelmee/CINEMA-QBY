import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/class/session';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-delete-time-table',
  templateUrl: './delete-time-table.component.html',
  styleUrls: ['./delete-time-table.component.scss']
})
export class DeleteTimeTableComponent implements OnInit {

  constructor(private sessionService: SessionService) { }

  selectedSession: Session = new Session({});

  sessions: Session[] = [];

  ngOnInit(): void {
    this.sessionService.findAll().subscribe(data => { this.sessions = data; });
  }

  onSubmit(): void{
    if (confirm("Are you sure you want to delete this Session ?")) {
      console.log(this.selectedSession) ;
      this.sessionService.delete(this.selectedSession.id).subscribe() ;
    }
    else {
      console.log("Delete Session ABORTED");
    }
  }
}
