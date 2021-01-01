import { Component, OnInit, Input } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import {faMarkdown} from '@fortawesome/free-brands-svg-icons';
import { DateService } from 'src/app/service/date.service';
import { PostService } from 'src/app/service/post.service';
import { Post } from '../../model/post';

@Component({
  selector: 'app-form-post',
  templateUrl: './form-post.component.html',
  styleUrls: ['./form-post.component.css', '../navbar/navbar.component.css']
})
export class FormPostComponent implements OnInit {
  @Input() postEditting: Post;
  @Input() flagEdit: boolean;
  faMarkdown = faMarkdown;
  formPost: FormGroup;
  postPreview = '';
  constructor(
    private fb: FormBuilder,
    private postService: PostService,
    private dateService: DateService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formPost = this.fb.group({
      heading: [this.flagEdit ? this.postEditting.heading : '', [Validators.required]],
      subHeading: [this.flagEdit ? this.postEditting.subHeading : '', [Validators.required]],
      urlImage: [this.flagEdit ? this.postEditting.urlImage : '', [Validators.required]],
      content: [this.flagEdit ? this.postEditting.content : '', [Validators.required]],
    });
    // console.log(this.formPost);
    this.postPreview = this.formPost.get('content').value;
  }

  submitPost(): void{
    const post = new Post();
    post.heading = this.formPost.get('heading').value;
    post.subHeading = this.formPost.get('subHeading').value;
    post.content = this.formPost.get('content').value;
    post.urlImage = this.formPost.get('urlImage').value;
    if (this.flagEdit){
      post.id = this.postEditting.id;
      post.dateCreate = this.postEditting.dateCreate;
      this.postService.updatePost(post);
    } else{
      post.dateCreate = this.dateService.getDayNow();
      this.postService.addPost(post);
    }
    this.router.navigateByUrl(`/post/${this.postEditting.id}`);
  }
  deletePost(): void{
    const idDelete: number = this.postEditting.id;
    this.postService.deletePost(idDelete);
    this.router.navigateByUrl('/home');
  }
  resizeInput(element: HTMLTextAreaElement): void{
    element.style.height = 'auto';
    element.style.height = element.scrollHeight + 'px';
    this.postPreview = this.formPost.get('content').value;
  }

}
