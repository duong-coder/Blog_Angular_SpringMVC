import { Component, OnInit, DoCheck, Input } from '@angular/core';
import { ActivatedRoute, NavigationStart, Router, UrlSegment } from '@angular/router';
import { faGithub } from '@fortawesome/free-brands-svg-icons';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  @Input() urlGithub;

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

  checkAtPageDetailPost(): void {
    this.router.events.subscribe((evt) => {
      if (evt instanceof NavigationStart) {
        const href = evt.url;
        const currentAccount = this.accountService.getCurrentAccountValue;
        console.log('href and current: ', href, currentAccount);

        if (href.includes('detail') && currentAccount) {
          this.showEditPost = true;
        }
      }
    });
  }

  editPost(): void {
    const idPost = this.route.snapshot.paramMap.get('id');
    this.router.navigateByUrl(`/duongnh/post/edit/${idPost}`);
  }
}
