import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../../model/post';
import { PostService } from '../../service/post.service';

@Component({
  selector: 'app-post-detail-page',
  templateUrl: './post-detail-page.component.html',
  styleUrls: ['./post-detail-page.component.css']
})
export class PostDetailPageComponent implements OnInit {
  post: Post = new Post();
  constructor(
    private route: ActivatedRoute,
    private postService: PostService
  ) { }

  ngOnInit(): void {
    this.getPostById();
  }
  getPostById(): void {
    const id = +this.route.snapshot.paramMap.get('id');

    this.postService.getPostById(id).subscribe(responsePost => {
      this.post = responsePost.body;
      console.log(this.post, responsePost);

    });
  }
}
