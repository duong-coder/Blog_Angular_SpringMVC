import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  posts: Post[];
  constructor(
    private postService: PostService
  ) { }

  ngOnInit(): void {
    this.getAllPost();
  }

  getAllPost(): void {
    // let arrPost: Array<Post> = null;
    this.postService.getAllPost().subscribe(
      responsePost => {
        this.posts = responsePost.body;
        this.posts = Array.from(this.posts).reverse();
      },
      error => {
        console.log('Loi dang nhap');
        this.posts = [];
      });
  }
}
