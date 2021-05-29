import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit  {

  constructor() {
  }

  currentPage:boolean[] = [false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false] ;
  previousPage:number = 0 ;

  ngOnInit(): void {
  }

  updatePage(index:number)
  {
      this.currentPage[this.previousPage] = false ;
      this.currentPage[index] = true ;
      this.previousPage = index ;
  }
}
