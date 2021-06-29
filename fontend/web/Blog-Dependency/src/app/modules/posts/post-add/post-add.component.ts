import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { faMarkdown } from '@fortawesome/free-brands-svg-icons';
import { Post } from 'src/app/model/post';
import { DateService } from 'src/app/service/date.service';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-post-add',
  templateUrl: './post-add.component.html',
  styleUrls: ['./post-add.component.css']
})
export class PostAddComponent implements OnInit, OnChanges {
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

  ngOnChanges(): void {
    this.formPost = this.fb.group({
      heading: [this.flagEdit ? this.postEditting.heading : '', [Validators.required]],
      subHeading: [this.flagEdit ? this.postEditting.subHeading : '', [Validators.required]],
      urlImage: [this.flagEdit ? this.postEditting.urlImage : '', [Validators.required]],
      content: [this.flagEdit ? this.postEditting.content : '', [Validators.required]],
    });
    // console.log(this.formPost);
    this.postPreview = this.formPost.get('content').value;
  }
  ngOnInit(): void {

  }

  submitPost(): void {
    const post = new Post();
    post.heading = this.formPost.get('heading').value;
    post.subHeading = this.formPost.get('subHeading').value;
    post.content = this.formPost.get('content').value;
    post.urlImage = this.formPost.get('urlImage').value;
    if (this.flagEdit) {
      post.id = this.postEditting.id;
      post.dateCreate = this.postEditting.dateCreate;
      this.postService.updatePost(post).subscribe({
        next: (next) => {
          console.log(next);
        },
        error: (err) => {
          console.error(err);
        },
        complete: () => {
          console.log(post);
          this.router.navigateByUrl(`/duongnh/post/detail/${this.postEditting.id}`);
        }
      });
    } else {
      post.dateCreate = this.dateService.getDayNow();
      console.log('INSERT', post);
      this.postService.addPost(post).subscribe({
        next: (next) => {
          console.log(next);
        },
        error: (err) => {
          console.error(err);
        },
        complete: () => {
          console.log(post);
          this.router.navigateByUrl('/duongnh/home');
        }
      });
    }
  }
  deletePost(): void {
    const idDelete: number = this.postEditting.id;
    this.postService.deletePost(idDelete).subscribe(post => {
      console.log(post);
      this.router.navigateByUrl('/duongnh/home');
    });
  }
  resizeInput(element: HTMLTextAreaElement): void {
    element.style.height = 'auto';
    element.style.height = element.scrollHeight + 'px';
    this.postPreview = this.formPost.get('content').value;
  }

}
