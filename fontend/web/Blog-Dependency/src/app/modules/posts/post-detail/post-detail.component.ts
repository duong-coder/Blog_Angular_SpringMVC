import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NavbarComponent } from 'src/app/common/navbar/navbar.component';
import { AccountLogin } from 'src/app/model/acccount-login';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css'],
})
export class PostDetailComponent implements OnInit, OnChanges {
  @Input() content: string;
  currentAccount: AccountLogin;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private accountService: AccountService
  ) { }

  ngOnChanges(): void {
    this.currentAccount = this.accountService.getCurrentAccountValue;
  }

  ngOnInit(): void {
    this.currentAccount = this.accountService.getCurrentAccountValue;
  }

  editPost(): void {
    if (this.currentAccount) {
      const url = this.router.url;
      const indexDetail = url.lastIndexOf('/');
      const idPost = +url.substring(indexDetail + 1);

      this.router.navigateByUrl(`/duongnh/post/edit/${idPost}`);
    }
  }
}
