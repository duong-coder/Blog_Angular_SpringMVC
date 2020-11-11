import { Component, OnInit, Input } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {faMarkdown} from '@fortawesome/free-brands-svg-icons';
import { DateService } from 'src/app/date.service';
import { PostService } from 'src/app/post.service';
import { Post } from '../../post';

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
    private dateService: DateService
  ) { }

  ngOnInit(): void {
    this.formPost = this.fb.group({
      heading: [this.flagEdit ? this.postEditting.title : '', [Validators.required]],
      subHeading: [this.flagEdit ? this.postEditting.subTitle : '', [Validators.required]],
      urlImage: [this.flagEdit ? this.postEditting.urlImage : '', [Validators.required]],
      content: [this.flagEdit ? this.postEditting.content : '', [Validators.required]],
    });
    console.log(this.formPost);
  }

  submitPost(): void{
    const post = new Post();
    post.title = this.formPost.get('heading').value;
    post.subTitle = this.formPost.get('subHeading').value;
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
  }
  resizeInput(element: HTMLTextAreaElement): void{
    // console.log(element);
    element.style.height = 'auto';
    element.style.height = element.scrollHeight + 'px';
    console.log(this.formPost.get('content').value);
    this.postPreview = this.formPost.get('content').value;
  }

}
