import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { Post } from '../post';

import {PostService} from '../post.service';

@Component({
  selector: 'app-edit-post-page',
  templateUrl: './edit-post-page.component.html',
  styleUrls: ['./edit-post-page.component.css']
})
export class EditPostPageComponent implements OnInit {
  post: Post;
  constructor(
    private route: ActivatedRoute,
    private postService: PostService
  ) { }

  ngOnInit(): void {
    this.getPostEdit();
  }
  getPostEdit(): void{
    const id = +this.route.snapshot.paramMap.get('id');
    this.postService.getPostById(id).subscribe(post => this.post = post);
    console.log('idPost:' + id, this.post);
  }
}
