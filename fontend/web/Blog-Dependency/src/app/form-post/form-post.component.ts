import { Component, OnInit, Input } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {faMarkdown} from '@fortawesome/free-brands-svg-icons';
import { Post } from '../post';

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
    private fb: FormBuilder
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

}
