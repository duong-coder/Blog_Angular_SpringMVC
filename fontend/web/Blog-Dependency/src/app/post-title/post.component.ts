import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-post-title',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  @Input() idPost: number;
  constructor() { }

  ngOnInit(): void {
  }

}
