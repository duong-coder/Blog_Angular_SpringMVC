import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, UrlSegment} from '@angular/router';
import {faGithub} from '@fortawesome/free-brands-svg-icons';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  faGithub = faGithub;
  showEditPost: boolean;
  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.checkAtPageDetailPost();
  }
  checkAtPageDetailPost(): void{
    console.log(this.route.snapshot.url);
    const pathExist = this.route.snapshot.url.find((urlSegment: UrlSegment) => {
      return urlSegment.path === 'post';
    });
    if (pathExist){
      this.showEditPost = true;
    }
  }
  editPost(): void{
    const idPost = this.route.snapshot.paramMap.get('id');
    this.router.navigateByUrl(`/edit/${idPost}`);
  }
}
