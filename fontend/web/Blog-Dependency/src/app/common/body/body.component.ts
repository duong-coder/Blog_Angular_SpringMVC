import { Component, OnInit } from '@angular/core';

import { Post } from 'src/app/model/post';
import { PostService } from '../../service/post.service';

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
    let arrPost: Array<Post> = null;
    this.postService.getAllPost().subscribe(accSub => {
      this.posts = accSub.postDTOs;
      this.posts = Array.from(this.posts).reverse();
    });
  }
}
