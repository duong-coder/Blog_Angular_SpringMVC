import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NavbarComponent } from 'src/app/common/navbar/navbar.component';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css'],
})
export class PostDetailComponent implements OnInit {
  @Input() content: string;
  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  editPost(): void{
    const idPost = this.route.snapshot.paramMap.get('id');
    this.router.navigateByUrl(`/duongnh/post/edit/${idPost}`);
  }
}
