import { Component, OnInit, DoCheck, Input} from '@angular/core';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { faGithub } from '@fortawesome/free-brands-svg-icons';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit{
  account: Account = new Account();
  
  faGithub = faGithub;
  showEditPost: boolean;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.checkAtPageDetailPost();
  }

  getAccountCurrent(): void{
    
  }

  checkAtPageDetailPost(): void {
    this.route.url.subscribe((urlSegment) => {
      console.log(urlSegment);
      const existUrlSegment = urlSegment.find((url) => {
        return url.path.includes('detail') ? url : null;
      });
      if (existUrlSegment != null){
        this.showEditPost = true;
      }
    });
  }
  editPost(): void {
    const idPost = this.route.snapshot.paramMap.get('id');
    this.router.navigateByUrl(`/post/edit/${idPost}`);
  }
}
