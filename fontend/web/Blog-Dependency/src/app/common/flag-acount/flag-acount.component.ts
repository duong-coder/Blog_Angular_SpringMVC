import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'app-flag-acount',
  templateUrl: './flag-acount.component.html',
  styleUrls: ['./flag-acount.component.css']
})
export class FlagAcountComponent implements OnInit {
  flagIsLoginPage = false;
  constructor(
    private location: Location
  ) { }

  ngOnInit(): void {
  }
  redirecPageLogin(): void{
    this.flagIsLoginPage = !this.flagIsLoginPage;
    if (!this.flagIsLoginPage){
      this.goBack();
    }
  }
  goBack(): void{
    this.location.back();
  }
}
