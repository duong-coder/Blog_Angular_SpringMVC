import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  posts: object[];
  constructor(
    private postService: PostService
  ) { }

  ngOnInit(): void {
    this.getAllPost();
  }

  getAllPost(): void{
    this.postService.getAllPost().subscribe((posts => this.posts = posts));
  }

}
