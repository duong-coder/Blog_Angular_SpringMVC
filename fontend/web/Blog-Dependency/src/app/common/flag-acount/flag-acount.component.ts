import { Component, Input, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, NavigationStart, Router } from '@angular/router';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-flag-acount',
  templateUrl: './flag-acount.component.html',
  styleUrls: ['./flag-acount.component.css']
})
export class FlagAcountComponent implements OnInit {
  @Input() isLoginPage: boolean;
  statusFlag = ['login', 'logout', 'goback'];
  currentFlag: string;

  constructor(
    private accountService: AccountService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.currentFlag = this.statusFlag[0];
  }

  ngOnInit(): void {
    if (this.isLoginPage) {
      this.currentFlag = this.statusFlag[2];
    } else {
      this.router.events.subscribe((evt) => {
        if (evt instanceof NavigationStart) {
          const url = evt.url;
          const currentAccount = this.accountService.getCurrentAccountValue;
          if (currentAccount) {
            this.currentFlag = this.statusFlag[1];
          } else {
            this.currentFlag = this.statusFlag[0];
          }
          if (url.includes('login')) {
            this.currentFlag = this.statusFlag[2];
          }

          console.log('CURRENT FLAG', this.currentFlag);

        }
      });
    }
  }

  redirecPage(): void {
    switch (this.currentFlag) {
      case this.statusFlag[0]: {
        this.goLoginPage();
        break;
      }
      case this.statusFlag[1]: {
        this.logout();
        break;
      }
      case this.statusFlag[2]: {
        this.goBack();
        break;
      }
      default: {
        this.goLoginPage();
        break;
      }
    }
  }

  goBack(): void {
    this.router.navigateByUrl('/duongnh/home');
  }

  goLoginPage(): void {
    this.accountService.logout();
    this.router.navigateByUrl('/login');
  }

  logout(): void {
    this.accountService.logout();
    this.goBack();
  }
}
