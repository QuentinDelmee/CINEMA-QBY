import { Component, OnInit } from '@angular/core';
import { Session } from 'src/app/class/session';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-time-table',
  templateUrl: './time-table.component.html',
  styleUrls: ['./time-table.component.scss']
})
export class TimeTableComponent implements OnInit {

  sessions : Session[] = [];

  constructor(private sessionService: SessionService) { }

  ngOnInit(): void {
    this.sessionService.findAll().subscribe(data => { this.sessions = data; });
  }

}
