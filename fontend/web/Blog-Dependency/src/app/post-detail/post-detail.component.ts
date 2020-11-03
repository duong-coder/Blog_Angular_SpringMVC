import { Component, Input, OnInit } from '@angular/core';
import {NavbarComponent} from '../navbar/navbar.component';
@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css'],
  providers: [NavbarComponent]
})
export class PostDetailComponent implements OnInit {
  @Input() content: string;
  constructor(
    private navbarComponent: NavbarComponent
  ) { }

  ngOnInit(): void {
  }
  editPost(): void{
    this.navbarComponent.editPost();
  }
}
