import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/class/session';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-update-time-table',
  templateUrl: './update-time-table.component.html',
  styleUrls: ['./update-time-table.component.scss']
})
export class UpdateTimeTableComponent implements OnInit {

  constructor(private sessionService: SessionService) { }

  selectedSession: any = {}

  sessions: Session[] = [];

  ngOnInit(): void {
    this.sessionService.findAll().subscribe(data => { this.sessions = data; });
  }

  onSubmit(): void{
    this.selectedSession.idDate = this.selectedSession.date + 'T' +this.selectedSession.time ;
    if (confirm("Are you sure you want to update this Session ?")) {
      this.sessionService.save(this.selectedSession).subscribe();
    }
    else {
      console.log("Update Session ABORTED");
    }
  }

}
